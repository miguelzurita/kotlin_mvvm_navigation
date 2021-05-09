package com.miguelzurita.demo.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.miguelzurita.demo.network.vo.OpenWeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OpenWeatherRepository {
    val openWeatherResponse = MutableLiveData<OpenWeatherResponse>()

    fun getWeather(): MutableLiveData<OpenWeatherResponse> {

        RetrofitClient.getAPI().getWeather("Republic of Malta, MT", "metric", "db931e927c64b513f44e93e89627dbb7").enqueue(object : Callback<OpenWeatherResponse> {
            override fun onFailure(call: Call<OpenWeatherResponse>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(call: Call<OpenWeatherResponse>, response: Response<OpenWeatherResponse>) {
                if (response.isSuccessful) {
                    Log.v("DEBUG : ", response.body().toString())
                    openWeatherResponse.value = response.body()
                } else {
                    Log.v("DEBUG : ", "error:" + response.errorBody())
                }

            }
        })

        return openWeatherResponse
    }
}