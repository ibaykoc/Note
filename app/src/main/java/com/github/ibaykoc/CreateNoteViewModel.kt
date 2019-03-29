/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:09 PM
 */

package com.github.ibaykoc

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateNoteViewModel(private val repository: NoteRepository) : ViewModel(), Observable {
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
        note.value?.let { repository.save(it) }
    }
}
