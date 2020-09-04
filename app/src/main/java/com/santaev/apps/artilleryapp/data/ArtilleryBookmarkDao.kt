package com.santaev.apps.artilleryapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

/**
 * The Data Access Object for the [ArtilleryBookmark] class.
 */
@Dao
interface ArtilleryBookmarkDao {
    @Query("SELECT * FROM artillery_bookmarks")
    fun getAll(): LiveData<List<ArtilleryBookmark>>

    @Query("SELECT EXISTS(SELECT 1 FROM artillery_bookmarks WHERE artillery_id = :artilleryId LIMIT 1)")
    fun exists(artilleryId: String): LiveData<Boolean>

    @Transaction
    @Query("SELECT * FROM artillery WHERE id IN (SELECT DISTINCT(artillery_id) FROM artillery_bookmarks)")
    fun getBookmarks(): LiveData<List<ArtilleryWithBookmark>>

    @Insert
    suspend fun insert(artilleryBookmark: ArtilleryBookmark): Long

    @Delete
    suspend fun delete(artilleryBookmark: ArtilleryBookmark)
}
