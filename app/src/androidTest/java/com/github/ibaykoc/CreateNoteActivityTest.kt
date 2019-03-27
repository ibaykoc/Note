
/*
 *  Created by Mochammad Iqbal on 3/27/19 7:03 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/27/19 7:03 PM
 */

package com.github.ibaykoc

import android.widget.Button
import android.widget.EditText
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateNoteActivityTest {

    @get:Rule
    val activity: ActivityTestRule<CreateNoteActivity> = ActivityTestRule(CreateNoteActivity::class.java)

    private val titleEditText by lazy { onView(withId(R.id.title_EditText)) }
    private val noteEditText by lazy { onView(withId(R.id.note_EditText)) }
    private val saveButton by lazy { onView(withId(R.id.save_Btn)) }

    @Test
    fun haveTitleEditTextWithCorrectProperty() {
        titleEditText.apply {
            check(matches(isAssignableFrom(EditText::class.java)))
            check(matches(isDisplayed()))
            check(matches(withHint("Title")))
            check(matches(hasFocus()))
        }
    }

    @Test
    fun haveNoteEditTextWithCorrectProperty() {
        noteEditText.apply {
            check(matches(isAssignableFrom(EditText::class.java)))
            check(matches(isDisplayed()))
            check(matches(withHint("Note")))
        }
    }
    @Test
    fun haveSaveButtonWithCorrectProperty() {
        saveButton.apply {
            check(matches(isAssignableFrom(Button::class.java)))
            check(matches(isDisplayed()))
            check(matches(withText("Save")))
        }
    }

    @Test
    fun whenSaveClicked_ActivityFinish() {
        saveButton.perform(click())
        assertTrue(activity.activity.isFinishing)
    }
}