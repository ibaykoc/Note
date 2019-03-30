/*
 *  Created by Mochammad Iqbal on 3/30/19 2:37 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 7:59 AM
 */

@file:Suppress("DEPRECATION")

package com.github.ibaykoc

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import kotlinx.coroutines.runBlocking
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
    fun saveLoadNoteProperly() {
        // Given
        val context = InstrumentationRegistry.getInstrumentation().context
        val noteToSave1 = Note(0, "Title1", "Note1")
        val noteToSave2 = Note(0, "Title2", "Note2")
        val sut = Room.inMemoryDatabaseBuilder(context, NoteLocalDatabase::class.java).build()

        // When
        runBlocking { sut.noteDao().insertAll(noteToSave1, noteToSave2) }

        // Then
        val expectedResult = listOf(
            Note(1, "Title1", "Note1"),
            Note(2, "Title2", "Note2")
        )
        val actualResult = runBlocking { sut.noteDao().getAll() }
        assertEquals(expectedResult, actualResult)
    }

}