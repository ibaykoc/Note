/*
 *  Created by Mochammad Iqbal on 3/30/19 7:56 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 7:30 AM
 */

package com.github.ibaykoc

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CreateNoteViewModel(private val repository: NoteRepository) : ViewModel(), Observable, CoroutineScope {
    private val _job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + _job

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    private val note = MutableLiveData<Note>().also { it.value = Note(0, "", "") }

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

    fun saveNote() {
        launch(Dispatchers.IO) {
            note.value?.let { repository.save(it) }
        }
    }
}
