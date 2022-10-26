package com.app.weatherforecast.adapter

import com.app.weatherforecast.R
import com.app.weatherforecast.databinding.ItemWeatherDayBinding
import com.app.weatherforecast.model.WeatherList

class WeatherDayAdapter : BaseRecyclerViewAdapter<WeatherList, ItemWeatherDayBinding>() {

    override fun getLayout() = R.layout.item_weather_day

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ItemWeatherDayBinding>,
        position: Int
    ) {
        holder.binding.weatherList = items[position]

        holder.binding.root.setOnClickListener {
            listener?.invoke(items[position])
        }
    }
}