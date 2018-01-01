package com.aliak.dev.fastreading.ui

import android.content.Intent
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.PresenterLifecycle
import com.aliak.dev.fastreading.domain.main.MainScreenPresenter
import com.aliak.dev.fastreading.ui.base.BaseLifecycleThemedActivity
import com.aliak.dev.fastreading.ui.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseLifecycleThemedActivity() {
    override fun initView() {
        main_fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
        }
    }

    override fun initPresenter(): PresenterLifecycle = MainScreenPresenter()

    override fun getResId(): Int = R.layout.activity_main

}
