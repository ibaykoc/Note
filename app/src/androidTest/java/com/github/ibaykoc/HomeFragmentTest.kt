/*
 *  Created by Mochammad Iqbal on 3/30/19 7:56 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/30/19 4:12 AM
 */

@file:Suppress("DEPRECATION")

package com.github.ibaykoc

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Note
 * Created by Mochammad Iqbal on 28/03/19.
 */
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    private val mockNavController by lazy { mockkClass(relaxed = true, type = NavController::class) }
    private val createNoteFAB by lazy { onView(withId(R.id.createNote_FAB)) }
    private val noteListRecyclerView by lazy { onView(withId(R.id.noteList_RecyclerView)) }

    @Before
    fun setup() {
        val scenario = launchFragmentInContainer<HomeFragment>(themeResId = R.style.Theme_AppCompat)
        scenario.onFragment {
            Navigation.setViewNavController(it.requireView(), mockNavController)
        }
    }

    @Test
    fun haveNoteListRecyclerView() {
        noteListRecyclerView.check(matches(isDisplayed()))
        noteListRecyclerView.check(matches(isAssignableFrom(RecyclerView::class.java)))
    }

    @Test
    fun haveCreateNoteFAB() {
        createNoteFAB.check(matches(isDisplayed()))
        createNoteFAB.check(matches(isAssignableFrom(FloatingActionButton::class.java)))
    }

    @Test
    fun whenCreateNoteFABClicked_openCreateNote() {
        createNoteFAB.perform(click())
        verify { mockNavController.navigate(R.id.action_homeFragment_to_createNoteFragment) }
    }
}