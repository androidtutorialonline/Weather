package com.app.weatherforecast.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.collections.List

@JsonClass(generateAdapter = true)
data class WeatherInfo(
    @Json(name = "city")
    val city: City? = City(),
    @Json(name = "cnt")
    val cnt: Int? = 0,
    @Json(name = "cod")
    val cod: String? = "",
    @Json(name = "list")
    val list: List<WeatherList>? = listOf(),
    @Json(name = "message")
    val message: Int? = 0
)