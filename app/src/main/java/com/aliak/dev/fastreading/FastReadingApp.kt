package com.aliak.dev.fastreading

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import com.aliak.dev.fastreading.di.AppComponent
import com.aliak.dev.fastreading.di.DaggerAppComponent
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

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

        Fabric.with(this, Crashlytics())
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}