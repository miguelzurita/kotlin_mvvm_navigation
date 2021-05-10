package com.miguelzurita.demo.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "devices")
data class Device(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String?,
    val macAddress: String?,
    val dateOfAdmission: String?
)