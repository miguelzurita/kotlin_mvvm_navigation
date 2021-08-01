package com.miguelzurita.demo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.ktx.performance
import com.google.firebase.perf.metrics.Trace
import com.miguelzurita.demo.adapter.RecyclerAdapter
import com.miguelzurita.demo.databinding.FragmentListBinding
import com.miguelzurita.demo.viewmodel.ListViewModel

/**
 * List all devices
 */
open class ListFragment : Fragment() {

    lateinit var viewmodel: ListViewModel
    private lateinit var binding: FragmentListBinding
    private lateinit var myTrace: Trace


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
        //custom trace
        myTrace = Firebase.performance.newTrace("load_local_devices")
        myTrace.start()
    }

    protected open fun configureUI() {
        binding.rvDevices.adapter = adapter
    }

    protected fun configureLiveDataObservers() {

        viewmodel.getAllDevicesLiveData().observe(this, Observer { devices ->
            devices?.let {
                adapter.updateDevices(devices)
                //trace time to load local devices
                myTrace.stop()
            }
        })
    }
}