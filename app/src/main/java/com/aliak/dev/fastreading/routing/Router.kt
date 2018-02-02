package com.aliak.dev.fastreading.routing

import android.content.Context

/**
 * @author Aliaksandr Novik
 */
interface Router {
    interface Main {
        fun navigateSettings(context: Context)
        fun navigateTraining(context: Context)
    }

    interface Training {
        fun navigateSchulteTraining(context: Context)
        fun navigateSchulteDescription(context: Context)
        fun navigateSchulteResult(context: Context)
    }
}