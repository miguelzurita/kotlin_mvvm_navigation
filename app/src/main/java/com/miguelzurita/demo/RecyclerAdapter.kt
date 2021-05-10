package com.miguelzurita.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.miguelzurita.demo.databinding.RecyclerViewDeviceItemBinding
import com.miguelzurita.demo.model.Device


/**
 * Adaptador de los albums
 */
class RecyclerAdapter(private val items: MutableList<Device>) :
    RecyclerView.Adapter<RecyclerAdapter.DeviceHolder>() {

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
        notifyDataSetChanged()
    }

    class DeviceHolder(private val binding: RecyclerViewDeviceItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private var device: Device? = null

        /**
         * Carga la informacion en el item
         */
        fun bind(device: Device) {
            this.device = device
            binding.tvName.text = device.name
            binding.tvMacAddress.text = device.macAddress
        }
    }
}