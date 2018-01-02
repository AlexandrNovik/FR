package com.aliak.dev.fastreading.ui

import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.afollestad.appthemeengine.Config
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.main.MainScreenPresenter
import com.aliak.dev.fastreading.mvp.MainContract
import com.aliak.dev.fastreading.ui.base.BaseLifecycleThemedActivity
import kotlinx.android.synthetic.main.activity_main.*
import utils.click

class MainActivity : BaseLifecycleThemedActivity<MainContract.Presenter>() {

    override fun initPresenter() = MainScreenPresenter()

    override fun getResId(): Int = R.layout.activity_main

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> presenter.navigateSettings(this@MainActivity)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        main_toolbar_text.text = getString(R.string.app_name)

        main_training.click { presenter.navigateTraining(this@MainActivity) }
        main_training_program.click { presenter.navigateTrainingProgram(this@MainActivity) }
        main_reading.click { presenter.navigateReading(this@MainActivity) }
        main_motivation.click { presenter.navigateMotivation(this@MainActivity) }
    }

    private fun View.setAccentBackground() {
        this.setBackgroundColor(Config.accentColor(this@MainActivity, ateKey))
    }


}
