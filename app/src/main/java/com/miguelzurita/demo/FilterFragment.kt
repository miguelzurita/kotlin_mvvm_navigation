package com.miguelzurita.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProviders
import com.miguelzurita.demo.databinding.FragmentFilterBinding
import com.miguelzurita.demo.viewmodel.ListViewModel

/**
 * List all devices filtered by mac address
 */
class FilterFragment : ListFragment() {

    private var searchString: String? = null
    private lateinit var binding: FragmentFilterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFilterBinding.inflate(inflater)
        viewmodel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        if (savedInstanceState != null) {
            searchString = savedInstanceState.getString(Constants.SEARCH_KEY)
        }

        return binding.root
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString(Constants.SEARCH_KEY, binding.svMacAddress.query.toString())
    }

    override fun configureUI() {
        binding.svMacAddress.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.getFilter()?.filter(query);
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.getFilter()?.filter(newText);
                return false
            }

        })

        binding.rvDevices.adapter = adapter

        //
        searchString?.let {
            binding.svMacAddress.setQuery(searchString, true)
        }
    }

}