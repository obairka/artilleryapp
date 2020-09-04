package com.santaev.apps.artilleryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.santaev.apps.artilleryapp.data.ArtilleryBookmarkRepository
import com.santaev.apps.artilleryapp.data.Artillery
import com.santaev.apps.artilleryapp.data.ArtilleryRepository

/**
 * Factory for creating a [ArtilleryDetailViewModel] with a constructor that takes a [ArtilleryRepository]
 * and an ID for the current [Artillery].
 */
class ArtilleryDetailViewModelFactory(
        private val artilleryRepository: ArtilleryRepository,
        private val artiileryBookmarkRepository: ArtilleryBookmarkRepository,
        private val artilleryId: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtilleryDetailViewModel(artilleryRepository, artiileryBookmarkRepository, artilleryId) as T
    }
}
