package com.santaev.apps.artilleryapp.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * This class captures the relationship between a [Artillery] and a user's [ArtilleryBookmark], which is
 * used by Room to fetch the related entities.
 */
data class ArtilleryWithBookmark(
        @Embedded
    val artillery: Artillery,

        @Relation(parentColumn = "id", entityColumn = "artillery_id")
    val artilleryBookmarks: List<ArtilleryBookmark> = emptyList()
)
