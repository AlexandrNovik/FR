package com.aliak.dev.fastreading.ui

import android.view.Menu
import android.view.MenuItem
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.main.MainScreenPresenter
import com.aliak.dev.fastreading.ui.base.BaseLifecycleThemedActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseLifecycleThemedActivity<MainScreenPresenter>() {
    override fun initView() {
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.app_name)
    }

    override fun initPresenter() = MainScreenPresenter()

    override fun getResId(): Int = R.layout.activity_main

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                presenter.startSettings(this@MainActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
