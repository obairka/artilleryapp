package com.santaev.apps.artilleryapp.data

/**
 * Repository module for handling data operations.
 */
class ArtilleryRepository private constructor(private val artilleryDao: ArtilleryDao) {

    fun getArtilleryList() = artilleryDao.getAll()

    fun getArtillery(artilleryId: String) = artilleryDao.getArtillery(artilleryId)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ArtilleryRepository? = null

        fun getInstance(artilleryDao: ArtilleryDao) =
            instance ?: synchronized(this) {
                instance ?: ArtilleryRepository(artilleryDao).also { instance = it }
            }
    }
}
