package com.miguelzurita.demo.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.miguelzurita.demo.model.Device
import com.miguelzurita.demo.model.DeviceRepository
import com.miguelzurita.demo.model.room.RoomRepository

class AddViewModel(
    private val repository: DeviceRepository = RoomRepository()
) : ViewModel() {

    var name = ObservableField<String>()
    var macAddress = ObservableField<String>()
    var dateOfAdmission = ObservableField<String>()
    private val saveLiveData = MutableLiveData<Boolean>()

    fun saveDevice() {
        updateDevice()
        return if (canSaveDevice()) {
            repository.saveDevice(device)
            saveLiveData.postValue(true)
        } else {
            saveLiveData.postValue(false)
        }
    }

    lateinit var device: Device

    fun updateDevice() {
        device = Device(null, name.get(), macAddress.get(), dateOfAdmission.get())
    }


    fun canSaveDevice(): Boolean {
        val currentName: String? = name.get()
        currentName?.let {
            return currentName.isNotEmpty()
        }
        return false

    }

}