package com.santaev.apps.artilleryapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.platform.app.InstrumentationRegistry
import com.santaev.apps.artilleryapp.utilities.getValue
import com.santaev.apps.artilleryapp.utilities.testCalendar
import com.santaev.apps.artilleryapp.utilities.testBookmark
import com.santaev.apps.artilleryapp.utilities.testItem
import com.santaev.apps.artilleryapp.utilities.testItems
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtilleryBookmarkDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var artilleryBookmarkDao: ArtilleryBookmarkDao
    private var testBookmarkId: Long = 0

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        artilleryBookmarkDao = database.artilleryBookmarkDao()

        database.artilleryDao().insertAll(testItems)
        testBookmarkId = artilleryBookmarkDao.insert(testBookmark)
    }

    @After fun closeDb() {
        database.close()
    }

    @Test fun testGetAll() = runBlocking {
        val artilleryBookmark = ArtilleryBookmark(
            testItems[1].artilleryId,
            testCalendar,
            testCalendar
        ).also { it.artilleryBookmarkId = 2 }
        artilleryBookmarkDao.insert(artilleryBookmark)
        assertThat(getValue(artilleryBookmarkDao.getAll()).size, equalTo(2))
    }

    @Test fun testDelete() = runBlocking {
        val artilleryBookmark = ArtilleryBookmark(
            testItems[1].artilleryId,
            testCalendar,
            testCalendar
        ).also { it.artilleryBookmarkId = 2 }
        artilleryBookmarkDao.insert(artilleryBookmark)
        assertThat(getValue(artilleryBookmarkDao.getAll()).size, equalTo(2))
        artilleryBookmarkDao.delete(artilleryBookmark)
        assertThat(getValue(artilleryBookmarkDao.getAll()).size, equalTo(1))
    }

    @Test fun testGetForArtillery() {
        assertTrue(getValue(artilleryBookmarkDao.exists(testItem.artilleryId)))
    }

    @Test fun testGetForArtillery_notFound() {
        assertFalse(getValue(artilleryBookmarkDao.exists(testItems[2].artilleryId)))
    }

    @Test fun testGetArtilleryWithBookmark() {
        val bookmarks = getValue(artilleryBookmarkDao.getBookmarks())
        assertThat(bookmarks.size, equalTo(1))

        assertThat(bookmarks[0].artillery, equalTo(testItem))
        assertThat(bookmarks[0].artilleryBookmarks.size, equalTo(1))
        assertThat(bookmarks[0].artilleryBookmarks[0], equalTo(testBookmark))
    }
}
