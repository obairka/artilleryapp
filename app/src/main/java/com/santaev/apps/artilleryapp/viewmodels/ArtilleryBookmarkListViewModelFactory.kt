package com.santaev.apps.artilleryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.santaev.apps.artilleryapp.data.ArtilleryBookmarkRepository

/**
 * Factory for creating a [ArtilleryBookmarkListViewModel] with a constructor that takes a
 * [ArtilleryBookmarkRepository].
 */
class ArtilleryBookmarkListViewModelFactory(
    private val repository: ArtilleryBookmarkRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtilleryBookmarkListViewModel(repository) as T
    }
}
