/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
 */

package com.github.ibaykoc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */
class CreateNoteViewModelTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun whenSaveNote_thenCallRepositorySave_withCorrectNote() {
        // Given
        val repoMock = mockkClass(relaxed = true, type = NoteRepository::class)
        val sut = CreateNoteViewModel(repoMock)
        val desireNote = Note(0, "Title", "Note")
        // When
        sut.setTitle(desireNote.title)
        sut.setNoteBody(desireNote.note)
        sut.saveNote()
        // Then
        verify { repoMock.save(desireNote) }
    }
}