package com.aliak.dev.fastreading

import android.app.Application
import com.aliak.dev.fastreading.di.AppComponent
import com.aliak.dev.fastreading.di.DaggerAppComponent

/**
 * @author Aliaksandr Novik
 */
class FastReadingApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
    }
}