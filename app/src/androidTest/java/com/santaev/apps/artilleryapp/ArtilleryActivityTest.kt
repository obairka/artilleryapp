package com.santaev.apps.artilleryapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class ArtilleryActivityTest {

    @Rule @JvmField
    var activityTestRule = ActivityTestRule(ArtilleryActivity::class.java)

    @Test fun clickAddArtillery_OpensArtilleryList() {
        onView(withId(R.id.add_artillery)).perform(click())
        onView(withId(R.id.artillery_list)).check(matches(isDisplayed()))
    }
}
