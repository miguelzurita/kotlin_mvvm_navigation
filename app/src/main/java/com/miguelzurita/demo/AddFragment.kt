package com.miguelzurita.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miguelzurita.demo.databinding.FragmentAddBinding

/**
 * A simple [Fragment] subclass.
 */
class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddBinding.inflate(inflater)
        return binding.root
    }

}