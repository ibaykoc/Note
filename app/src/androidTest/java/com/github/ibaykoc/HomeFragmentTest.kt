/*
 *  Created by Mochammad Iqbal on 3/28/19 4:00 AM
 *  Copyright (c) 2019 . All rights reserved.
 *  Last modified 3/28/19 4:00 AM
 */

@file:Suppress("DEPRECATION")

package com.github.ibaykoc

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.Assert.*
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

    @Before
    fun setup() {
        val scenario = launchFragmentInContainer<HomeFragment>(themeResId = R.style.Theme_AppCompat)
        scenario.onFragment {
            Navigation.setViewNavController(it.requireView(), mockNavController)
        }
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