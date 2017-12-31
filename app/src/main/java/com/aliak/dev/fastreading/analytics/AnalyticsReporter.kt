package com.aliak.dev.fastreading.analytics

interface AnalyticsReporter {
    companion object {
        const val ATTRIBUTES_APP_VERSION = "app_version"
        const val EVENT_TYPE_NAVIGATION = "navigation"

        const val EVENT_NAME_SETTINGS = "settings"
    }

    fun reportNavigationSettings()
}