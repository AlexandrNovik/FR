package com.aliak.dev.fastreading.analytics

interface AnalyticsReporter {
    companion object {
        const val ATTRIBUTES_APP_VERSION = "app_version"
        const val EVENT_TYPE_NAVIGATION = "navigation"

        const val EVENT_NAME_SETTINGS = "Settings screen"
        const val EVENT_NAME_TRAINING = "Training screen"
        const val EVENT_NAME_SCHULTE_TRAINING = "Schulte screen"
        const val EVENT_NAME_SCHULTE_DESCRIPTION = "Schulte description screen"
    }

    fun reportNavigationSettings()
    fun reportNavigationTraining()
    fun reportNavigationSchulteTraining()
    fun reportNavigationSchulteDescription()
}