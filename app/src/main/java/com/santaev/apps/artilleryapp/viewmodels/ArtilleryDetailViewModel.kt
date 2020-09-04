package com.santaev.apps.artilleryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santaev.apps.artilleryapp.BuildConfig
import com.santaev.apps.artilleryapp.ArtilleryDetailFragment
import com.santaev.apps.artilleryapp.data.ArtilleryBookmarkRepository
import com.santaev.apps.artilleryapp.data.ArtilleryRepository
import kotlinx.coroutines.launch

/**
 * The ViewModel used in [ArtilleryDetailFragment].
 */
class ArtilleryDetailViewModel(
        artilleryRepository: ArtilleryRepository,
        private val artilleryBookmarkRepository: ArtilleryBookmarkRepository,
        private val artilleryId: String
) : ViewModel() {

    val exists = artilleryBookmarkRepository.exists(artilleryId)
    val artillery = artilleryRepository.getArtillery(artilleryId)

    fun addArtillery() {
        viewModelScope.launch {
            artilleryBookmarkRepository.createBookmark(artilleryId)
        }
    }
}
