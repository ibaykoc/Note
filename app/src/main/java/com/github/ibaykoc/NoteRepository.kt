/*
 *  Created by Mochammad Iqbal on 3/30/19 2:37 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 2:37 PM
 */

package com.github.ibaykoc

/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */
class NoteRepository(private val localDataSource: NoteLocalDatabase) {
    suspend fun save(note: Note) {
        localDataSource.noteDao().insertAll(note)
    }

    suspend fun loadAll(): List<Note> {
        return localDataSource.noteDao().getAll()
    }

    suspend fun getByUID(noteUID: Int): Note {
        return localDataSource.noteDao().getByUID(noteUID)
    }
}