package com.miguelzurita.demo.viewmodel

import androidx.lifecycle.ViewModel
import com.miguelzurita.demo.model.DeviceRepository
import com.miguelzurita.demo.model.room.RoomRepository


class ListViewModel(
    private val repository: DeviceRepository = RoomRepository()
) : ViewModel() {

    private val allDevicesLiveData = repository.getAllDevices()

    fun getAllDevicesLiveData() = allDevicesLiveData

}
