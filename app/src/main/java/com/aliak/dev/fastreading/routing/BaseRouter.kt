package com.aliak.dev.fastreading.routing

import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.analytics.AnalyticsReporter
import javax.inject.Inject

/**
 * @author Aliaksandr Novik
 */
open class BaseRouter @Inject constructor() {
    @Inject lateinit var analytics: AnalyticsReporter

    init {
        FastReadingApp.appComponent.inject(this)
    }
}