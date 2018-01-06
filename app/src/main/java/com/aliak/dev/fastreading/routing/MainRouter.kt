package com.aliak.dev.fastreading.routing

import android.content.Context
import android.content.Intent
import com.aliak.dev.fastreading.ui.settings.SettingsActivity
import com.aliak.dev.fastreading.ui.training.TrainingActivity

/**
 * @author Aliaksandr Novik
 */
class MainRouter : BaseRouter(), Router.Main {
    override fun navigateTraining(context: Context) {
        analytics.reportNavigationTraining()
        context.startActivity(Intent(context, TrainingActivity::class.java))
    }

    override fun navigateSettings(context: Context) {
        analytics.reportNavigationSettings()
        context.startActivity(Intent(context, SettingsActivity::class.java))
    }
}