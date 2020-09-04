package com.santaev.apps.artilleryapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.santaev.apps.artilleryapp.data.AppDatabase
import com.santaev.apps.artilleryapp.data.ArtilleryBookmarkRepository
import com.santaev.apps.artilleryapp.data.ArtilleryRepository
import com.santaev.apps.artilleryapp.utilities.getValue
import com.santaev.apps.artilleryapp.utilities.testItem
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtilleryDetailViewModelTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var viewModel: ArtilleryDetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        val artilleryRepository = ArtilleryRepository.getInstance(appDatabase.artilleryDao())
        val artilleryBookmarkRepository = ArtilleryBookmarkRepository.getInstance(
            appDatabase.artilleryBookmarkDao()
        )
        viewModel = ArtilleryDetailViewModel(artilleryRepository, artilleryBookmarkRepository, testItem.artilleryId)
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() {
        assertFalse(getValue(viewModel.exists))
    }
}
