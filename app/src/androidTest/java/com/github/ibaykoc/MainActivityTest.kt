/*
 *  Created by Mochammad Iqbal on 3/27/19 7:09 PM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/27/19 6:14 PM
 */

@file:Suppress("DEPRECATION")

package com.github.ibaykoc

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.intent.Intents.*
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.*
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = IntentsTestRule(MainActivity::class.java)

    private val createNoteFAB by lazy { onView(withId(R.id.createNote_FAB)) }


    @Test
    fun haveCreateNoteFAB() {
        createNoteFAB.check(matches(isAssignableFrom(FloatingActionButton::class.java)))
    }

    @Test
    fun whenCreateNoteFABClicked_thenOpenCreateNoteActivity() {
        createNoteFAB.perform(click())

        intended(
            allOf(
                hasComponent(
                    hasClassName(CreateNoteActivity::class.java.name)
                )
            )
        )
    }
}