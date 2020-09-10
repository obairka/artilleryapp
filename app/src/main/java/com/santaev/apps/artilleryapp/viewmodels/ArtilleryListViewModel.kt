package com.santaev.apps.artilleryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.santaev.apps.artilleryapp.ArtilleryListFragment
import com.santaev.apps.artilleryapp.data.Artillery
import com.santaev.apps.artilleryapp.data.ArtilleryRepository

/**
 * The ViewModel for [ArtilleryListFragment].
 */
class ArtilleryListViewModel internal constructor(
        artilleryRepository: ArtilleryRepository
) : ViewModel() {

    val artilleryList: LiveData<List<Artillery>> = artilleryRepository.getArtilleryList()
}
