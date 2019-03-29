/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
 */

package com.github.ibaykoc

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Note
 * Created by Mochammad Iqbal on 29/03/19.
 */

@Database(entities = [Note::class], version = 1)
abstract class NoteLocalDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}