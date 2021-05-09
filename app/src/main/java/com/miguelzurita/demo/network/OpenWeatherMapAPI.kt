package com.miguelzurita.demo.network

import com.miguelzurita.demo.network.vo.OpenWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenWeatherMapAPI {

    //Example call
//    http://api.openweathermap.org/data/2.5/weather?q=Malta&units=metric&appid=db931e927c64b513f44e93e89627dbb7

//    @GET("/weather?q={city}&units=metric&appid=db931e927c64b513f44e93e89627dbb7")
    @GET("/data/2.5/weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Call<OpenWeatherResponse>

}