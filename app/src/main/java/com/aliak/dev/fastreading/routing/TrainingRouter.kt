package com.aliak.dev.fastreading.routing

import android.content.Context
import android.content.Intent
import com.aliak.dev.fastreading.ui.training.schulte.SchulteActivity
import com.aliak.dev.fastreading.ui.training.schulte.SchulteDescriptionActivity

/**
 * @author Aliaksandr Novik
 */
class TrainingRouter : BaseRouter(), Router.Training {
    override fun navigateSchulteTraining(context: Context) {
        analytics.reportNavigationSchulteTraining()
        context.startActivity(Intent(context, SchulteActivity::class.java))
    }
    override fun navigateSchulteDescription(context: Context) {
        analytics.reportNavigationSchulteDescription()
        context.startActivity(Intent(context, SchulteDescriptionActivity::class.java))
    }
}