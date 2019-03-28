/*
 *  Created by Mochammad Iqbal on 3/28/19 9:08 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/28/19 9:08 AM
 */

package com.github.ibaykoc

import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */
@RunWith(AndroidJUnit4::class)
class CreateNoteFragmentTest {
    private val titleEditText by lazy { onView(withId(R.id.title_EditText)) }
    private val noteEditText by lazy { onView(withId(R.id.note_EditText)) }
    private val saveButton by lazy {onView(withId(R.id.save_Btn))}
    @Before
    fun setup() {
        launchFragmentInContainer<CreateNoteFragment>(themeResId = R.style.Theme_AppCompat)
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
}