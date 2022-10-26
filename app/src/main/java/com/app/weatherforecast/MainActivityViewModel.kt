package com.app.weatherforecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.weatherforecast.model.WeatherInfo
import com.app.weatherforecast.data.api.MainRepository
import com.app.weatherforecast.data.api.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val apiHelper: MainRepository
) : ViewModel() {

    val weatherInfo = MutableLiveData<Resource<WeatherInfo>>()

    fun getDayWeatherInfo() = viewModelScope.launch {
        weatherInfo.postValue(Resource.loading(null))
        apiHelper.getDayWeatherInfo("44.34", "10.99")
            .catch { e ->
                weatherInfo.postValue(Resource.error(e.toString(), null))
            }
            .collect {
                weatherInfo.postValue(Resource.success(it))
            }
    }
}