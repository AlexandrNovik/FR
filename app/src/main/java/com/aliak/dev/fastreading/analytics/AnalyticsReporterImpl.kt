package com.aliak.dev.fastreading.analytics

import android.content.Context
import com.aliak.dev.fastreading.analytics.AnalyticsReporter.Companion.ATTRIBUTES_APP_VERSION
import com.aliak.dev.fastreading.analytics.AnalyticsReporter.Companion.EVENT_NAME_SCHULTE_DESCRIPTION
import com.aliak.dev.fastreading.analytics.AnalyticsReporter.Companion.EVENT_NAME_SCHULTE_TRAINING
import com.aliak.dev.fastreading.analytics.AnalyticsReporter.Companion.EVENT_NAME_SETTINGS
import com.aliak.dev.fastreading.analytics.AnalyticsReporter.Companion.EVENT_NAME_TRAINING
import com.aliak.dev.fastreading.analytics.AnalyticsReporter.Companion.EVENT_TYPE_NAVIGATION
import com.crashlytics.android.answers.Answers
import com.crashlytics.android.answers.ContentViewEvent

class AnalyticsReporterImpl(context: Context) : AnalyticsReporter {

    private val version: String =
            context.packageManager.getPackageInfo(context.packageName, 0).versionName

    private fun reportNavigationEvent(eventName: String) {
        Answers.getInstance().logContentView(
                ContentViewEvent()
                        .putContentName(eventName)
                        .putContentType(EVENT_TYPE_NAVIGATION)
                        .putCustomAttribute(ATTRIBUTES_APP_VERSION, version))
    }

    override fun reportNavigationSchulteTraining() {
        reportNavigationEvent(EVENT_NAME_SCHULTE_TRAINING)
    }

    override fun reportNavigationTraining() {
        reportNavigationEvent(EVENT_NAME_TRAINING)
    }

    override fun reportNavigationSettings() {
        reportNavigationEvent(EVENT_NAME_SETTINGS)

    }

    override fun reportNavigationSchulteDescription() {
        reportNavigationEvent(EVENT_NAME_SCHULTE_DESCRIPTION)
    }

}