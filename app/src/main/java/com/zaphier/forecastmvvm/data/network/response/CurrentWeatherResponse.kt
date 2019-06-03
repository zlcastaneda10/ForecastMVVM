package com.zaphier.forecastmvvm.data.network.response

import com.google.gson.annotations.SerializedName
import com.zaphier.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.zaphier.forecastmvvm.data.db.entity.Location


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)