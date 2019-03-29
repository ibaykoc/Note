/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
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
    fun getAll(): List<Note>

    @Insert
    fun insertAll(vararg notes: Note)

    @Delete
    fun delete(note: Note)
}