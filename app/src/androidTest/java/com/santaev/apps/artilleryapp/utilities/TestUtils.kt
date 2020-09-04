package com.santaev.apps.artilleryapp.utilities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import com.santaev.apps.artilleryapp.data.ArtilleryBookmark
import com.santaev.apps.artilleryapp.data.Artillery
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import java.util.Calendar

/**
 * [Artillery] objects used for tests.
 */
val testItems = arrayListOf(
    Artillery("1", "Apple", "A red fruit", 1),
    Artillery("2", "B", "Description B", 1),
    Artillery("3", "C", "Description C", 2)
)
val testItem = testItems[0]

/**
 * [Calendar] object used for tests.
 */
val testCalendar: Calendar = Calendar.getInstance().apply {
    set(Calendar.YEAR, 1998)
    set(Calendar.MONTH, Calendar.SEPTEMBER)
    set(Calendar.DAY_OF_MONTH, 4)
}

/**
 * [ArtilleryBookmark] object used for tests.
 */
val testBookmark = ArtilleryBookmark(testItem.artilleryId, testCalendar, testCalendar)

/**
 * Returns the content description for the navigation button view in the toolbar.
 */
fun getToolbarNavigationContentDescription(activity: Activity, toolbarId: Int) =
    activity.findViewById<Toolbar>(toolbarId).navigationContentDescription as String

/**
 * Simplify testing Intents with Chooser
 *
 * @param matcher the actual intent before wrapped by Chooser Intent
 */
fun chooser(matcher: Matcher<Intent>): Matcher<Intent> = allOf(
    hasAction(Intent.ACTION_CHOOSER),
    hasExtra(`is`(Intent.EXTRA_INTENT), matcher)
)