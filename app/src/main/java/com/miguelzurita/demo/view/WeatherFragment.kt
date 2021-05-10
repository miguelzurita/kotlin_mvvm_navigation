package com.miguelzurita.demo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.miguelzurita.demo.databinding.FragmentWeatherBinding
import com.miguelzurita.demo.viewmodel.WeatherViewModel

/**
 * A simple [Fragment] subclass.
 */
class WeatherFragment : Fragment() {

    private lateinit var viewmodel: WeatherViewModel
    lateinit var binding: FragmentWeatherBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWeatherBinding.inflate(inflater)
        initializeObserver()
        return binding.root
    }

    private fun initializeObserver() {
        viewmodel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        viewmodel.getWeather()!!.observe(this, Observer { openWeatherResponse ->
            binding.etTemperature.text = "${openWeatherResponse.main.temp}°C"
            binding.etCity.text = openWeatherResponse.name
            if (openWeatherResponse.weather.size > 0) {
                binding.etWeather.text = openWeatherResponse.weather[0].main
            }
        })
    }


}