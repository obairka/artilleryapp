package com.santaev.apps.artilleryapp.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.santaev.apps.artilleryapp.data.AppDatabase
import com.santaev.apps.artilleryapp.data.ArtilleryBookmarkRepository
import com.santaev.apps.artilleryapp.data.ArtilleryRepository
import com.santaev.apps.artilleryapp.viewmodels.ArtilleryBookmarkListViewModelFactory
import com.santaev.apps.artilleryapp.viewmodels.ArtilleryDetailViewModelFactory
import com.santaev.apps.artilleryapp.viewmodels.ArtilleryListViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    private fun getArtilleryRepository(context: Context): ArtilleryRepository {
        return ArtilleryRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).artilleryDao()
        )
    }

    private fun getArtilleryBookmarksRepository(context: Context): ArtilleryBookmarkRepository {
        return ArtilleryBookmarkRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).artilleryBookmarkDao()
        )
    }

    fun provideArtilleryBookmarkListViewModelFactory(
        context: Context
    ): ArtilleryBookmarkListViewModelFactory {
        return ArtilleryBookmarkListViewModelFactory(getArtilleryBookmarksRepository(context))
    }

    fun provideArtilleryListViewModelFactory(fragment: Fragment): ArtilleryListViewModelFactory {
        return ArtilleryListViewModelFactory(getArtilleryRepository(fragment.requireContext()))
    }

    fun provideArtilleryDetailViewModelFactory(
            context: Context,
            artilleryId: String
    ): ArtilleryDetailViewModelFactory {
        return ArtilleryDetailViewModelFactory(
            getArtilleryRepository(context),
            getArtilleryBookmarksRepository(context),
            artilleryId
        )
    }
}
