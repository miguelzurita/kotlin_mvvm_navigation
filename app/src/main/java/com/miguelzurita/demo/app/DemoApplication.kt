package com.miguelzurita.demo.app

import android.app.Application
import androidx.room.Room
import com.miguelzurita.demo.model.room.DeviceDatabase

class DemoApplication : Application() {
    companion object {
        lateinit var database: DeviceDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, DeviceDatabase::class.java, "device_database").build()
    }
}