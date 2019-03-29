/*
 *  Created by Mochammad Iqbal on 3/29/19 6:38 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/29/19 6:38 PM
 */

@file:Suppress("DEPRECATION")

package com.github.ibaykoc

import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */
@RunWith(AndroidJUnit4::class)
class CreateNoteFragmentTest {
    private val titleEditText by lazy { onView(withId(R.id.title_EditText)) }
    private val noteEditText by lazy { onView(withId(R.id.note_EditText)) }
    private val saveButton by lazy {onView(withId(R.id.save_Btn))}
    private val sutScenario by lazy { launchFragmentInContainer<CreateNoteFragment>(themeResId = R.style.Theme_AppCompat) }
    private val sutViewModelMock = mockkClass(relaxed = true, type = CreateNoteViewModel::class)
    @Before
    fun setup() {
        val moduleMock = module {
            viewModel(override = true) {
                sutViewModelMock
            }
        }
        loadKoinModules(moduleMock)
        sutScenario
    }
    @Test
    fun haveTitleEditTextWithCorrectProperty() {
        titleEditText.apply {
            check(matches(isDisplayed()))
            check(matches(isAssignableFrom(EditText::class.java)))
            check(matches(withHint("Title")))
        }
    }
    @Test
    fun haveNoteEditTextWithCorrectProperty() {
        noteEditText.apply {
            check(matches(isDisplayed()))
            check(matches(isAssignableFrom(EditText::class.java)))
            check(matches(withHint("Note")))
        }
    }
    @Test
    fun haveSaveButtonWithCorrectProperty() {
        saveButton.apply {
            arrayOf(isDisplayed(), isAssignableFrom(Button::class.java), withText("Save"))
                .forEach { check(matches(it)) }
        }
    }

    @Test
    fun whenSaveClicked_CallViewModelSaveNote() {
        saveButton.perform(click())
        verify(exactly = 1) { sutViewModelMock.saveNote() }
    }
}