/*
 *  Created by Mochammad Iqbal on 3/30/19 7:56 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 7:56 AM
 */

package com.github.ibaykoc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockkClass
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Note
 * Created by Mochammad Iqbal on 30/03/19.
 */
class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val noteRepositoryMock by lazy { mockkClass(type = NoteRepository::class, relaxed = true) }
    private val sut by lazy { HomeViewModel(noteRepositoryMock) }

    @Before
    fun setup() {
        noteRepositoryMock
    }

    @Test
    fun shouldCallNoteRepositoryLoadAllOnInit() {
        sut
        coVerify(exactly = 1) { noteRepositoryMock.loadAll() }
    }

    @Test
    fun shouldHaveCorrectNotes() {
        // Given
        val noteOnDB = listOf(Note(1, "Title", "Note"))
        coEvery { noteRepositoryMock.loadAll() }.returns(noteOnDB)

        // When
        sut

        // Then
        assertEquals(noteOnDB, sut.notes.value)
    }
}