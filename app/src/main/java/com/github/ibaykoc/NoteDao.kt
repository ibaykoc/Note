/*
 *  Created by Mochammad Iqbal on 3/30/19 2:37 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 2:37 PM
 */

package com.github.ibaykoc

import androidx.room.*

/**
 * Note
 * Created by Mochammad Iqbal on 29/03/19.
 */
@Dao
interface NoteDao {
    @Query("SELECT * FROM note WHERE uid=:noteUID")
    suspend fun getByUID(noteUID: Int): Note

    @Query("SELECT * FROM note")
    suspend fun getAll(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg notes: Note)

    @Delete
    suspend fun delete(note: Note)
}