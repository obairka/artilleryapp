package com.santaev.apps.artilleryapp.data

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.Calendar
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR

class ArtilleryBookmarkTest {

    @Test
    fun testDefaultValues() {
        val artilleryBookmark = ArtilleryBookmark("1")
        val cal = Calendar.getInstance()
        assertYMD(cal, artilleryBookmark.addedDate)
        assertYMD(cal, artilleryBookmark.lastUpdatedDate)
        assertEquals(0L, artilleryBookmark.artilleryBookmarkId)
    }

    private fun assertYMD(expectedCal: Calendar, actualCal: Calendar) {
        assertThat(actualCal.get(YEAR), equalTo(expectedCal.get(YEAR)))
        assertThat(actualCal.get(MONTH), equalTo(expectedCal.get(MONTH)))
        assertThat(actualCal.get(DAY_OF_MONTH), equalTo(expectedCal.get(DAY_OF_MONTH)))
    }
}
