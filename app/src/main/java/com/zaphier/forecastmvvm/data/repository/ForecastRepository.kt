package com.zaphier.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.zaphier.forecastmvvm.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric:Boolean) : LiveData< out UnitSpecificCurrentWeatherEntry>
}