package com.santaev.apps.artilleryapp.viewmodels

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.santaev.apps.artilleryapp.data.ArtilleryRepository

/**
 * Factory for creating a [ArtilleryListViewModel] with a constructor that takes a [ArtilleryRepository].
 */
class ArtilleryListViewModelFactory(
        private val repository: ArtilleryRepository,
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return ArtilleryListViewModel(repository, handle) as T
    }
}
