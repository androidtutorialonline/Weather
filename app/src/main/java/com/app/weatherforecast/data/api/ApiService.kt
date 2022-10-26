package com.app.weatherforecast.data.api

import com.app.weatherforecast.model.WeatherInfo
import retrofit2.http.*

interface ApiService {

    @GET("/data/2.5/forecast")
    suspend fun getDayWeatherInfo(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String
    ): WeatherInfo


}