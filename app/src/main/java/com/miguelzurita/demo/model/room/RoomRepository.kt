package com.miguelzurita.demo.model.room

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.miguelzurita.demo.app.DemoApplication
import com.miguelzurita.demo.model.Device
import com.miguelzurita.demo.model.DeviceRepository

class RoomRepository : DeviceRepository {

    private val deviceDAO: DeviceDAO = DemoApplication.database.deviceDAO()

    init {

    }

    override fun saveDevice(device: Device) {
        InsertAsyncTask(deviceDAO).execute(device)
    }

    override fun getAllDevices() = deviceDAO.getAllDevices()

    override fun clearAllDevices() {
        TODO("Not yet implemented")
    }

    private class InsertAsyncTask internal constructor(private val dao: DeviceDAO) : AsyncTask<Device, Void, Void>() {
        override fun doInBackground(vararg params: Device): Void? {
            dao.insert(params[0])
            return null
        }
    }
}