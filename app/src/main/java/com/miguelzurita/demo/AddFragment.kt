package com.miguelzurita.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.miguelzurita.demo.databinding.FragmentAddBinding
import com.miguelzurita.demo.viewmodel.AddViewModel

/**
 * A simple [Fragment] subclass.
 */
class AddFragment : Fragment() {

    private lateinit var viewmodel: AddViewModel
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddBinding.inflate(inflater)
        viewmodel = ViewModelProviders.of(this).get(AddViewModel::class.java)
        binding.viewmodel = viewmodel

        initializeObserver()
        configureUI()

        return binding.root
    }

    private fun initializeObserver() {
        viewmodel.saveLiveData.observe(this, Observer {
            if (it) {
//                show toast success on save
            }
        })
    }

    private fun configureUI() {

    }

}