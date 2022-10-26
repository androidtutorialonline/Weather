package com.app.weatherforecast.data.api

import javax.inject.Inject


class MainRepository @Inject constructor (private val apiHelper: ApiHelperImpl) {

    suspend fun getDayWeatherInfo(lat: String, lon: String) = apiHelper.getDayWeatherInfo(lat, lon)

}