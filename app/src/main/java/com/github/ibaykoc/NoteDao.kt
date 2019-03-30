/*
 *  Created by Mochammad Iqbal on 3/30/19 7:56 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 7:28 AM
 */

package com.github.ibaykoc

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * Note
 * Created by Mochammad Iqbal on 29/03/19.
 */
@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    suspend fun getAll(): List<Note>

    @Insert
    suspend fun insertAll(vararg notes: Note)

    @Delete
    suspend fun delete(note: Note)
}