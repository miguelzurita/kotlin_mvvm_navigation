package com.miguelzurita.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miguelzurita.demo.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

}