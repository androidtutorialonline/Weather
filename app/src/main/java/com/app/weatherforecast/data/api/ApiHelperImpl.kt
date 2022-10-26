package com.app.weatherforecast.data.api

import com.app.weatherforecast.MainActivity
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiHelperImpl  @Inject constructor (private val apiService: ApiService) : ApiHelper {

    override suspend fun getDayWeatherInfo(lat: String, lon: String) = flow {
        emit(value = apiService.getDayWeatherInfo(lat, lon, MainActivity.appid))
    }

}