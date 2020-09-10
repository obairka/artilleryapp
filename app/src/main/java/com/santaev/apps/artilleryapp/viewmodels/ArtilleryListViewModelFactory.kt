package com.santaev.apps.artilleryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.santaev.apps.artilleryapp.data.ArtilleryRepository

/**
 * Factory for creating a [ArtilleryListViewModel] with a constructor that takes a [ArtilleryRepository].
 */
class ArtilleryListViewModelFactory(
        private val repository: ArtilleryRepository,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtilleryListViewModel(repository) as T
    }
}
