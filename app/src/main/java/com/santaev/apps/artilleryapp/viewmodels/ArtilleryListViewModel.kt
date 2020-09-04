package com.santaev.apps.artilleryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.santaev.apps.artilleryapp.ArtilleryListFragment
import com.santaev.apps.artilleryapp.data.Artillery
import com.santaev.apps.artilleryapp.data.ArtilleryRepository

/**
 * The ViewModel for [ArtilleryListFragment].
 */
class ArtilleryListViewModel internal constructor(
        artilleryRepository: ArtilleryRepository,
        private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val artilleryList: LiveData<List<Artillery>> = getSavedGrowZoneNumber().switchMap {
        if (it == NO_GROW_ZONE) {
            artilleryRepository.getArtilleryList()
        } else {
            artilleryRepository.getArtilleryList()
        }
    }

    fun setGrowZoneNumber(num: Int) {
        savedStateHandle.set(GROW_ZONE_SAVED_STATE_KEY, num)
    }

    fun clearGrowZoneNumber() {
        savedStateHandle.set(GROW_ZONE_SAVED_STATE_KEY, NO_GROW_ZONE)
    }

    fun isFiltered() = getSavedGrowZoneNumber().value != NO_GROW_ZONE

    private fun getSavedGrowZoneNumber(): MutableLiveData<Int> {
        return savedStateHandle.getLiveData(GROW_ZONE_SAVED_STATE_KEY, NO_GROW_ZONE)
    }

    companion object {
        private const val NO_GROW_ZONE = -1
        private const val GROW_ZONE_SAVED_STATE_KEY = "GROW_ZONE_SAVED_STATE_KEY"
    }
}
