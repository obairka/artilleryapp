package com.santaev.apps.artilleryapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artillery")
data class Artillery(
        @PrimaryKey @ColumnInfo(name = "id") val artilleryId: String,
        val name: String,
        val description: String,
        val imageUrl: String? = ""
) {
    override fun toString() = name
}
