package com.miguelzurita.demo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miguelzurita.demo.network.OpenWeatherRepository
import com.miguelzurita.demo.network.vo.OpenWeatherResponse

class WeatherViewModel(
    private val repository: OpenWeatherRepository = OpenWeatherRepository()
) : ViewModel() {

    var weatherLiveData: MutableLiveData<OpenWeatherResponse>? = null

    private val allDevicesLiveData = repository.openWeatherResponse

    fun getWeather() : LiveData<OpenWeatherResponse>? {
        weatherLiveData = repository.getWeather()
        return weatherLiveData
    }

}