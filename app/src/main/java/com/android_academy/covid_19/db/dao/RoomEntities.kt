package com.android_academy.covid_19.db.dao

import android.location.Location
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android_academy.covid_19.db.util.DBConstants.INFECTED_LOCATIONS_TABLE_NAME
import com.android_academy.covid_19.db.util.DBConstants.USERS_LOCATIONS_TABLE_NAME
import com.android_academy.covid_19.network.service.InfectedLocationModel
import java.util.Date

@Entity(tableName = INFECTED_LOCATIONS_TABLE_NAME)
data class RoomInfectedLocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "start_time")
    val startTime: Date,
    @ColumnInfo(name = "end_time")
    val endTime: Date,
    @ColumnInfo(name = "lat")
    val lat: Double,
    @ColumnInfo(name = "lon")
    val lon: Double,
    @ColumnInfo(name = "radius")
    val radius: Double
) {
    fun toInfectedLocationModel(): InfectedLocationModel {
        return InfectedLocationModel(
            id, startTime, endTime, lat, lon, radius
        )
    }
}

@Entity(tableName = USERS_LOCATIONS_TABLE_NAME)
data class RoomUserLocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "lat")
    val lat: Double,
    @ColumnInfo(name = "lon")
    val lon: Double,
    @ColumnInfo(name = "accuracy")
    val accuracy: Float,
    @ColumnInfo(name = "speed")
    val speed: Float,
    @ColumnInfo(name = "time")
    val time: Long,
    @ColumnInfo(name = "provider")
    val provider: String
)

fun Location.toRoomLocationEntity() = RoomUserLocationEntity(
    lat = this.latitude,
    lon = this.longitude,
    accuracy = this.accuracy,
    speed = this.speed,
    time = this.time,
    provider = this.provider
)
