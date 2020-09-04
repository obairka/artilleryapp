package com.santaev.apps.artilleryapp.data

class ArtilleryBookmarkRepository private constructor(
    private val artilleryBookmarkDao: ArtilleryBookmarkDao
) {

    suspend fun createBookmark(artilleryId: String) {
        val artilleryBookmark = ArtilleryBookmark(artilleryId)
        artilleryBookmarkDao.insert(artilleryBookmark)
    }

    suspend fun remove(artilleryBookmark: ArtilleryBookmark) {
        artilleryBookmarkDao.delete(artilleryBookmark)
    }

    fun exists(artilleryId: String) =
        artilleryBookmarkDao.exists(artilleryId)

    fun getBookmarks() = artilleryBookmarkDao.getBookmarks()

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ArtilleryBookmarkRepository? = null

        fun getInstance(artilleryBookmarkDao: ArtilleryBookmarkDao) =
            instance ?: synchronized(this) {
                instance ?: ArtilleryBookmarkRepository(artilleryBookmarkDao).also { instance = it }
            }
    }
}
