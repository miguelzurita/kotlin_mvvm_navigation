package com.miguelzurita.demo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.miguelzurita.demo.databinding.RecyclerViewDeviceItemBinding
import com.miguelzurita.demo.model.Device


/**
 * Device adapter
 */
class RecyclerAdapter(private val items: MutableList<Device>) : RecyclerView.Adapter<RecyclerAdapter.DeviceHolder>() {

    private var itemsListFull: ArrayList<Device> = ArrayList(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceHolder {
        return DeviceHolder(
            RecyclerViewDeviceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DeviceHolder, position: Int) = holder.bind(items[position])

    fun updateDevices(devices: List<Device>) {
        items.clear()
        items.addAll(devices)
        itemsListFull.addAll(devices)
        notifyDataSetChanged()
    }

    class DeviceHolder(private val binding: RecyclerViewDeviceItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private var device: Device? = null

        /**
         * Load date in the item
         */
        fun bind(device: Device) {
            this.device = device
            binding.tvName.text = device.name
            binding.tvMacAddress.text = device.macAddress
        }
    }

    fun getFilter(): Filter? = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults? {
            val filteredList: MutableList<Device> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                filteredList.addAll(itemsListFull)
            } else {
                for (item in itemsListFull) {
                    if (item.macAddress != null && item.macAddress.toLowerCase().contains(constraint.toString().toLowerCase().trim())) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults) {
            items.clear()
            items.addAll(results.values as ArrayList<Device>)
            notifyDataSetChanged()
        }
    }
}