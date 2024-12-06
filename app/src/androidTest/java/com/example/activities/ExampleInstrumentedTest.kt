package com.example.activities

import android.app.Activity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityRule1: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)
    @get:Rule
    var activityRule2: ActivityTestRule<TipActivity> =
        ActivityTestRule(TipActivity::class.java)
    @Test
    fun useAppContext() {
        Espresso.onView(withId(R.id.editTextSum)).perform(ViewActions.typeText("500"))
        Espresso.onView(withId(R.id.buttonSend)).perform(click())
        Espresso.onView(withId(R.id.textViewTotal)).check(ViewAssertions.matches(withText("525")))
    }
}