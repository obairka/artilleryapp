package com.santaev.apps.artilleryapp.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.santaev.apps.artilleryapp.utilities.getValue
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtilleryDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var artilleryDao: ArtilleryDao
    private val artilleryA = Artillery("1", "A", "", 1, 1, "")
    private val artilleryB = Artillery("2", "B", "", 1, 1, "")
    private val artilleryC = Artillery("3", "C", "", 2, 2, "")

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        artilleryDao = database.artilleryDao()

        artilleryDao.insertAll(listOf(artilleryB, artilleryC, artilleryA))
    }

    @After fun closeDb() {
        database.close()
    }

    @Test fun testGetAll() {
        val list = getValue(artilleryDao.getAll())
        assertThat(list.size, equalTo(3))

        // Ensure list is sorted by name
        assertThat(list[0], equalTo(artilleryA))
        assertThat(list[1], equalTo(artilleryB))
        assertThat(list[2], equalTo(artilleryC))
    }

    @Test fun testGetArtillery() {
        assertThat(getValue(artilleryDao.getArtillery(artilleryA.artilleryId)), equalTo(artilleryA))
    }
}
