/*
 *  Created by Mochammad Iqbal on 3/30/19 7:56 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 7:40 AM
 */

package com.github.ibaykoc

import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel(private val noteRepository: NoteRepository) : ViewModel(), CoroutineScope, LifecycleObserver {
    private val _job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + _job
    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    init {
        launch {
            _notes.value = withContext(Dispatchers.IO) { noteRepository.loadAll() }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun refresh() {
        launch {
            _notes.value = withContext(Dispatchers.IO) { noteRepository.loadAll() }
        }
    }

}
