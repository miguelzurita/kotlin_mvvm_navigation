package com.miguelzurita.demo.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.miguelzurita.demo.model.Device

@Database(entities = [(Device::class)], version = 1)
abstract class DeviceDatabase : RoomDatabase() {
    abstract fun deviceDAO(): DeviceDAO
}