/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
 */

package com.github.ibaykoc

/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */
class NoteRepository(val localDataSource: NoteLocalDatabase) {
    fun save(note: Note) {
        localDataSource.noteDao().insertAll(note)
    }
}