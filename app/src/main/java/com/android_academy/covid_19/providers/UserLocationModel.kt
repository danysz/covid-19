package com.android_academy.covid_19.providers

import com.android_academy.covid_19.db.dao.RoomUserLocationEntity

data class UserLocationModel(
    val id: Int? = null,
    val lat: Double,
    val lon: Double,
    val accuracy: Float,
    val speed: Float,
    val time: Long,
    val provider: String
)

fun fromRoomEntity(roomEntity: RoomUserLocationEntity) = UserLocationModel(
    id = roomEntity.id,
    lat = roomEntity.lat,
    lon = roomEntity.lon,
    accuracy = roomEntity.accuracy,
    speed = roomEntity.speed,
    time = roomEntity.time,
    provider = roomEntity.provider
)
