package com.miguelzurita.demo.app

import android.app.Application
import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.miguelzurita.demo.model.room.DeviceDatabase

class DemoApplication : MultiDexApplication() {
    companion object {
        lateinit var database: DeviceDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, DeviceDatabase::class.java, "device_database").build()

        FirebaseApp.initializeApp(applicationContext);
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
    }
}