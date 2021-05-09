package com.miguelzurita.demo.network.vo


data class OpenWeatherResponse(
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val timezone: Int,
    val weather: List<Weather>,
    val wind: Wind
)