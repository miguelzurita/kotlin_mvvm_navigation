package com.miguelzurita.demo.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "devices")
data class Device(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val macAddress: String?,
    val name: String?,
    val dateOfAdmission: String?
)