package com.aliak.dev.fastreading.ui.settings

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.support.annotation.ColorInt
import android.support.annotation.StyleRes
import android.view.MenuItem
import android.view.View
import com.afollestad.appthemeengine.ATE
import com.afollestad.appthemeengine.Config
import com.afollestad.appthemeengine.customizers.ATEActivityThemeCustomizer
import com.afollestad.appthemeengine.prefs.ATEColorPreference
import com.afollestad.appthemeengine.prefs.ATESwitchPreference
import com.afollestad.materialdialogs.color.ColorChooserDialog
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.ui.base.BaseThemedActivity

class SettingsActivity : BaseThemedActivity(),
        ColorChooserDialog.ColorCallback,
        ATEActivityThemeCustomizer {

    @StyleRes
    override fun getActivityTheme(): Int {
        // Overrides what's set in the current ATE Config
        return if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_theme", false))
            R.style.AppThemeDark_ActionBar
        else
            R.style.AppTheme_ActionBar
    }

    override fun onColorSelection(dialog: ColorChooserDialog, @ColorInt selectedColor: Int) {
        val config = ATE.config(this, ateKey)
        when (dialog.title) {
            R.string.primary_color -> config.primaryColor(selectedColor)
            R.string.accent_color -> {
                config.accentColor(selectedColor)
                // We've overridden the navigation view selected colors in the default config,
                // which means we are responsible for keeping those colors up to date.
                config.navigationViewSelectedIcon(selectedColor)
                config.navigationViewSelectedText(selectedColor)
            }
            R.string.primary_text_color -> config.textColorPrimary(selectedColor)
            R.string.secondary_text_color -> config.textColorSecondary(selectedColor)
        }
        config.commit()
        recreate() // recreation needed to reach the checkboxes in the preferences layout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preference_activity_custom)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, SettingsFragment()).commit()
        } else {
            val frag = fragmentManager.findFragmentById(R.id.content_frame) as SettingsFragment
            frag?.invalidateSettings()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}

class SettingsFragment : PreferenceFragment() {

    private var mAteKey: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        invalidateSettings()
    }

    fun invalidateSettings() {
        mAteKey = (activity as SettingsActivity).ateKey

        val primaryColorPref = findPreference("primary_color") as ATEColorPreference
        primaryColorPref.setColor(Config.primaryColor(activity, mAteKey), Color.BLACK)
        primaryColorPref.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            ColorChooserDialog.Builder(activity as SettingsActivity, R.string.primary_color)
                    .preselect(Config.primaryColor(activity, mAteKey))
                    .show()
            true
        }

        val accentColorPref = findPreference("accent_color") as ATEColorPreference
        accentColorPref.setColor(Config.accentColor(activity, mAteKey), Color.BLACK)
        accentColorPref.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            ColorChooserDialog.Builder(activity as SettingsActivity, R.string.accent_color)
                    .preselect(Config.accentColor(activity, mAteKey))
                    .show()
            true
        }

        val textColorPrimaryPref = findPreference("text_primary") as ATEColorPreference
        textColorPrimaryPref.setColor(Config.textColorPrimary(activity, mAteKey), Color.BLACK)
        textColorPrimaryPref.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            ColorChooserDialog.Builder(activity as SettingsActivity, R.string.primary_text_color)
                    .preselect(Config.textColorPrimary(activity, mAteKey))
                    .show()
            true
        }

        val textColorSecondaryPref = findPreference("text_secondary") as ATEColorPreference
        textColorSecondaryPref.setColor(Config.textColorSecondary(activity, mAteKey), Color.BLACK)
        textColorSecondaryPref.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            ColorChooserDialog.Builder(activity as SettingsActivity, R.string.secondary_text_color)
                    .preselect(Config.textColorSecondary(activity, mAteKey))
                    .show()
            true
        }

        findPreference("dark_theme").onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, _ ->
            // Marks both theme configs as changed so MainActivity restarts itself on return
            Config.markChanged(activity, "light_theme")
            Config.markChanged(activity, "dark_theme")
            // The dark_theme preference value gets saved by Android in the default PreferenceManager.
            // It's used in getATEKey() of both the Activities.
            activity.recreate()
            true
        }

        val statusBarPref = findPreference("colored_status_bar") as ATESwitchPreference
        val navBarPref = findPreference("colored_nav_bar") as ATESwitchPreference

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            statusBarPref.isChecked = Config.coloredStatusBar(activity, mAteKey)
            statusBarPref.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                ATE.config(activity, mAteKey)
                        .coloredStatusBar(newValue as Boolean)
                        .apply(activity)
                true
            }


            navBarPref.isChecked = Config.coloredNavigationBar(activity, mAteKey)
            navBarPref.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                ATE.config(activity, mAteKey)
                        .coloredNavigationBar(newValue as Boolean)
                        .apply(activity)
                true
            }
        } else {
            statusBarPref.isEnabled = false
            statusBarPref.setSummary(R.string.not_available_below_lollipop)
            navBarPref.isEnabled = false
            navBarPref.setSummary(R.string.not_available_below_lollipop)
        }

    }
}