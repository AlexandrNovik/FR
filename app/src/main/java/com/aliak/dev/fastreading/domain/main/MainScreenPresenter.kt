package com.aliak.dev.fastreading.domain.main

import android.content.Intent
import android.view.View
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.analytics.AnalyticsReporter
import com.aliak.dev.fastreading.domain.PresenterLifecycle
import com.aliak.dev.fastreading.ui.settings.SettingsActivity
import javax.inject.Inject

class MainScreenPresenter : PresenterLifecycle {
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
}