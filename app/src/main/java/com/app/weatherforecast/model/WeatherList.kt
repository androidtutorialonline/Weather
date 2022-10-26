package com.app.weatherforecast.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.collections.List

@JsonClass(generateAdapter = true)
data class WeatherList(
    @Json(name = "clouds")
    val clouds: Clouds? = Clouds(),
    @Json(name = "dt")
    val dt: Int? = 0,
    @Json(name = "dt_txt")
    val dtTxt: String? = "",
    @Json(name = "main")
    val main: Main? = Main(),
    @Json(name = "pop")
    val pop: Double? = 0.0,
    @Json(name = "rain")
    val rain: Rain? = Rain(),
    @Json(name = "sys")
    val sys: Sys? = Sys(),
    @Json(name = "visibility")
    val visibility: Int? = 0,
    @Json(name = "weather")
    val weather: List<Weather?>? = listOf(),
    @Json(name = "wind")
    val wind: Wind? = Wind()
)