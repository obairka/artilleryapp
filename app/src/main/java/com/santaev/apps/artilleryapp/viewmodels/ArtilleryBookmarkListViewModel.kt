package com.santaev.apps.artilleryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.santaev.apps.artilleryapp.data.ArtilleryBookmarkRepository
import com.santaev.apps.artilleryapp.data.ArtilleryWithBookmark

class ArtilleryBookmarkListViewModel internal constructor(
        artiileryBookmarkRepository: ArtilleryBookmarkRepository
) : ViewModel() {
    val artilleryWithBookmark: LiveData<List<ArtilleryWithBookmark>> =
        artiileryBookmarkRepository.getBookmarks()
}
