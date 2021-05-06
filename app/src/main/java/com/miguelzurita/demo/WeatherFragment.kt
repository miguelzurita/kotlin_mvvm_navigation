package com.miguelzurita.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miguelzurita.demo.databinding.FragmentWeatherBinding

/**
 * A simple [Fragment] subclass.
 */
class WeatherFragment : Fragment() {

    lateinit var binding: FragmentWeatherBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWeatherBinding.inflate(inflater)
        return binding.root
    }

}