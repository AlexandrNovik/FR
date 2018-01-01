package com.aliak.dev.fastreading.routing

import android.content.Context

/**
 * @author Aliaksandr Novik
 */
interface Router {
    interface Main{
        fun navigateSettings(context: Context)
    }
}