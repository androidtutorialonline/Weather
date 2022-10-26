package com.app.weatherforecast

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.weatherforecast.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

import androidx.activity.viewModels
import com.app.weatherforecast.adapter.WeatherDayAdapter
import com.app.weatherforecast.data.api.StatusCalled
import com.app.weatherforecast.model.WeatherList

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: WeatherDayAdapter
    private lateinit var mBinding: ActivityMainBinding

    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setAdapter(mBinding)

        viewModel.getDayWeatherInfo()

        viewModel.weatherInfo.observe(this) {
            when (it.status) {
                StatusCalled.SUCCESS -> {
                    mBinding.progressCircular.visibility = View.GONE
                    it.data?.let { weatherInfo -> renderList(weatherInfo.list) }
                    mBinding.dayListId.visibility = View.VISIBLE
                }
                StatusCalled.LOADING -> {
                    mBinding.progressCircular.visibility = View.VISIBLE
                    mBinding.dayListId.visibility = View.GONE
                }
                StatusCalled.ERROR -> {
                    //Handle Error
                    mBinding.progressCircular.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun renderList(weatherList: List<WeatherList>?) {
        weatherList?.let {
            mAdapter.addItems(it)
            mBinding.weatherList = it.get(0)
        }
    }

    private fun setAdapter(mBinding: ActivityMainBinding) {
        mAdapter = WeatherDayAdapter()
        mBinding.dayListId.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        mBinding.dayListId.layoutManager = layoutManager
        mBinding.dayListId.adapter = mAdapter
        mAdapter.addItems(ArrayList())

        mAdapter.listener = { item ->
            //selectedDayWeather(item)
            mBinding.weatherList = item
        }
    }

    companion object {
        const val appid = "845c80df095bc1ec9bd3d100381845d5"
    }


}