package com.santaev.apps.artilleryapp.viewmodels

import com.santaev.apps.artilleryapp.data.ArtilleryWithBookmark
import java.text.SimpleDateFormat
import java.util.*

class ArtilleryWithBookmarkViewModel(artilleryWithBookmark: ArtilleryWithBookmark) {
    private val artillery = checkNotNull(artilleryWithBookmark.artillery)
    private val artilleryBookmark = artilleryWithBookmark.artilleryBookmarks[0]

    val lastUpdatedDateString: String = dateFormat.format(artilleryBookmark.lastUpdatedDate.time)
    val imageUrl
        get() = artillery.imageUrl
    val artilleryName
        get() = artillery.name
    val artilleryDateString: String = dateFormat.format(artilleryBookmark.addedDate.time)
    val artilleryId
        get() = artillery.artilleryId

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale("ru"))
    }
}
