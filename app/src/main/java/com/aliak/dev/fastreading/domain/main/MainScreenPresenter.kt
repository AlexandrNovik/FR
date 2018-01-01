package com.aliak.dev.fastreading.domain.main

import android.content.Context
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.analytics.AnalyticsReporter
import com.aliak.dev.fastreading.domain.PresenterLifecycle
import com.aliak.dev.fastreading.routing.MainRouter
import com.aliak.dev.fastreading.routing.Router
import javax.inject.Inject

class MainScreenPresenter : PresenterLifecycle {
    @Inject lateinit var analytics: AnalyticsReporter
    @Inject lateinit var router: Router.Main

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

    fun startSettings(context: Context) {
        router.navigateSettings(context)
        analytics.reportNavigationSettings()
    }
}