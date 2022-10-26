package com.app.weatherforecast.data.api

import com.app.weatherforecast.model.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface ApiHelper {
    suspend fun getDayWeatherInfo(lat: String, lon: String): Flow<WeatherInfo>
}