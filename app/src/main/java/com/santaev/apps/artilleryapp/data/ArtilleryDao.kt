package com.santaev.apps.artilleryapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArtilleryDao {
    @Query("SELECT * FROM artillery ORDER BY name")
    fun getAll(): LiveData<List<Artillery>>

    @Query("SELECT * FROM artillery WHERE id = :artilleryId")
    fun getArtillery(artilleryId: String): LiveData<Artillery>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(artilleryList: List<Artillery>)
}
