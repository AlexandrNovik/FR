package com.aliak.dev.fastreading.databinding.viewmodel

import android.view.View
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.analytics.AnalyticsReporter
import com.aliak.dev.fastreading.databinding.ViewModelLifecycle
import javax.inject.Inject

class MainScreenViewModel : ViewModelLifecycle {
    @Inject lateinit var analytics: AnalyticsReporter

    init {
        FastReadingApp.appComponent.inject(this)
    }

    override fun initialize() {

    }

    override fun resume() {

    }

    override fun pause() {

    }

    override fun release() {

    }

    fun onNewPasswordClick(view: View) {
        analytics.reportNavigationSettings()
    }
}