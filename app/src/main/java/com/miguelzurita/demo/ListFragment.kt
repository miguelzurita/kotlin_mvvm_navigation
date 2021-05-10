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
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewmodel: ListViewModel
    lateinit var binding: FragmentListBinding

    private val adapter = RecyclerAdapter(mutableListOf())
//    lateinit var adapter:RecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        println("onCreateView")
        binding = FragmentListBinding.inflate(inflater)
        viewmodel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        configureUI()
        configureLiveDataObservers()
    }

    private fun configureLiveDataObservers() {
        viewmodel.getAllDevicesLiveData().observe(this, Observer { devices ->
            devices?.let {
//                println("get all devices")
//                println(devices)
                adapter.updateDevices(devices)
            }
        })
    }

    private fun configureUI() {
        //mock recycler
//        val device1:Device = Device(1, "2", "3", "4")
//        adapter = RecyclerAdapter(mutableListOf(device1, device1))
        binding.rvDevices.layoutManager = LinearLayoutManager(activity)
        binding.rvDevices.adapter = adapter
//        binding.rvDevices.setHasFixedSize(true)
    }

}