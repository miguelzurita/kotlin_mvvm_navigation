package com.miguelzurita.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miguelzurita.demo.databinding.FragmentFilterBinding

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : Fragment() {

    lateinit var binding: FragmentFilterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFilterBinding.inflate(inflater)
        return binding.root
    }

}