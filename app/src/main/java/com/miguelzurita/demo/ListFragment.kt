package com.miguelzurita.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelzurita.demo.databinding.FragmentListBinding
import com.miguelzurita.demo.model.Device
import com.miguelzurita.demo.viewmodel.ListViewModel

/**
 * List all devices
 */
class ListFragment : Fragment() {

    private lateinit var viewmodel: ListViewModel
    lateinit var binding: FragmentListBinding

    private val adapter = RecyclerAdapter(mutableListOf())

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


    private fun configureUI() {
        binding.rvDevices.adapter = adapter
    }

    private fun configureLiveDataObservers() {
        viewmodel.getAllDevicesLiveData().observe(this, Observer { devices ->
            devices?.let {
                adapter.updateDevices(devices)
            }
        })
    }
}