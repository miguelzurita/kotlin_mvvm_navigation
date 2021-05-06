package com.miguelzurita.demo.model

import androidx.lifecycle.LiveData

interface DeviceRepository {
    fun saveDevice(device: Device)
    fun getAllDevices():LiveData<List<Device>>
    fun clearAllDevices()
}