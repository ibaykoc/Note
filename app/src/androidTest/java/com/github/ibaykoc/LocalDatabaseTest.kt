/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
 */

@file:Suppress("DEPRECATION")

package com.github.ibaykoc

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Note
 * Created by Mochammad Iqbal on 29/03/19.
 */
@RunWith(AndroidJUnit4::class)
class LocalDatabaseTest {

    @Test
    fun saveNoteProperly() {
        // Given
        val context = InstrumentationRegistry.getInstrumentation().context
        val noteToSave1 = Note(0, "Title1", "Note1")
        val noteToSave2 = Note(0, "Title2", "Note2")
        val sut = Room.inMemoryDatabaseBuilder(context, NoteLocalDatabase::class.java).build()

        // When
        sut.noteDao().insertAll(noteToSave1, noteToSave2)

        // Then
        val expectedResult = listOf(
            Note(1, "Title1", "Note1"),
            Note(2, "Title2", "Note2")
        )
        assertEquals(expectedResult, sut.noteDao().getAll())
    }

}