package com.miguelzurita.demo.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.miguelzurita.demo.model.Device

@Dao
interface DeviceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(device: Device)

    @Delete
    fun clearDevices(vararg device: Device)

    @Query("SELECT * FROM devices ORDER BY name ASC")
    fun getAllDevices(): LiveData<List<Device>>
}