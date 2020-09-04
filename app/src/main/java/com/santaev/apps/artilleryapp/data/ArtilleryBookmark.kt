package com.santaev.apps.artilleryapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Calendar

@Entity(
    tableName = "artillery_bookmarks",
    foreignKeys = [
        ForeignKey(entity = Artillery::class, parentColumns = ["id"], childColumns = ["artillery_id"])
    ],
    indices = [Index("artillery_id")]
)
data class ArtilleryBookmark(
    @ColumnInfo(name = "artillery_id") val artilleryId: String,

    @ColumnInfo(name = "added_date") val addedDate: Calendar = Calendar.getInstance(),

    @ColumnInfo(name = "last_updated_date")
    val lastUpdatedDate: Calendar = Calendar.getInstance()
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var artilleryBookmarkId: Long = 0
}
