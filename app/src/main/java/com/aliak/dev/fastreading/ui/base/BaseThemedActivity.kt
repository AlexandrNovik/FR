package com.aliak.dev.fastreading.ui.base

import android.preference.PreferenceManager
import com.afollestad.appthemeengine.ATEActivity

open class BaseThemedActivity : ATEActivity() {
    override fun getATEKey(): String? {
        val dark = PreferenceManager
                .getDefaultSharedPreferences(this)
                .getBoolean("dark_theme", false)
        return if (dark) "dark_theme"
        else "light_theme"
    }
}