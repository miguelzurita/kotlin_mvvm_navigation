package com.miguelzurita.demo.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit?

    val baseURL: String = "http://api.openweathermap.org/"

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .build()
    }

    fun getAPI(): OpenWeatherMapAPI {
        return retrofit!!.create(OpenWeatherMapAPI::class.java)
    }
}