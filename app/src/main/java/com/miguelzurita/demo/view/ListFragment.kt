package com.miguelzurita.demo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.miguelzurita.demo.adapter.RecyclerAdapter
import com.miguelzurita.demo.databinding.FragmentListBinding
import com.miguelzurita.demo.viewmodel.ListViewModel

/**
 * List all devices
 */
open class ListFragment : Fragment() {

    lateinit var viewmodel: ListViewModel
    private lateinit var binding: FragmentListBinding

    protected val adapter = RecyclerAdapter(mutableListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(inflater)
        viewmodel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureUI()
        configureLiveDataObservers()
    }

    protected open fun configureUI() {
        binding.rvDevices.adapter = adapter
    }

    protected fun configureLiveDataObservers() {
        viewmodel.getAllDevicesLiveData().observe(this, Observer { devices ->
            devices?.let {
                adapter.updateDevices(devices)
            }
        })
    }
}