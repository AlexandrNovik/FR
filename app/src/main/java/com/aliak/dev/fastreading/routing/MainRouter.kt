package com.aliak.dev.fastreading.routing

import android.content.Context
import android.content.Intent
import com.aliak.dev.fastreading.ui.settings.SettingsActivity
import javax.inject.Inject

/**
 * @author Aliaksandr Novik
 */
class MainRouter @Inject constructor() : Router.Main {
    override fun navigateSettings(context: Context) {
        context.startActivity(Intent(context, SettingsActivity::class.java))
    }
}