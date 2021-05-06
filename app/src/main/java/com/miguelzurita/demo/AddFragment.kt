package com.miguelzurita.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
//        binding = DataBindingUtil.setContentView(activity, R.layout.fragment_add)
        viewmodel = ViewModelProviders.of(this).get(AddViewModel::class.java)
        binding.viewmodel = viewmodel

        configureUI()

        return binding.root
    }

    private fun configureUI() {

    }

}