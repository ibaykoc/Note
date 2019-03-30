/*
 *  Created by Mochammad Iqbal on 3/30/19 2:37 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 9:42 AM
 */

package com.github.ibaykoc

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CreateNoteViewModel(private val noteUID: Int, private val repository: NoteRepository) : ViewModel(), Observable,
    CoroutineScope {
    private val _job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + _job

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    val note = MutableLiveData<Note>()

    init {
        launch {
            note.value = if (noteUID == -1)
                Note(0, "", "")
            else
                withContext(Dispatchers.IO) {
                    repository.getByUID(noteUID)
                }
        }
    }

    @Bindable
    fun getTitle() = note.value?.title

    fun setTitle(value: String) {
        if (note.value?.title != value) note.value?.title = value
    }

    @Bindable
    fun getNoteBody() = note.value?.note

    fun setNoteBody(value: String) {
        if (note.value?.note != value) note.value?.note = value
    }

    fun saveNote(onSaved: () -> Unit) {
        launch {
            withContext(Dispatchers.IO) {
                note.value?.let { repository.save(it) }
            }
            onSaved()
        }
    }
}
