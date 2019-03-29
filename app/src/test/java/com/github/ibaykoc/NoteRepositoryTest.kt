/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
 */

package com.github.ibaykoc

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * Note
 * Created by Mochammad Iqbal on 29/03/19.
 */
class NoteRepositoryTest {
    @Test
    fun whenSaveNote_callLocalDataBaseInsertAll() {
        // Given
        val noteToSave = Note(1, "Title", "Note")
        val localDBMock = mockk<NoteLocalDatabase>(relaxed = true)
        val sut = NoteRepository(localDBMock)

        // When
        sut.save(noteToSave)

        // Then
        verify(exactly = 1) { localDBMock.noteDao().insertAll(noteToSave) }
    }
}