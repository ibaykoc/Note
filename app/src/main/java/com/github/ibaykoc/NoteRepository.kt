/*
 *  Created by Mochammad Iqbal on 3/30/19 7:56 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 7:56 AM
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
}