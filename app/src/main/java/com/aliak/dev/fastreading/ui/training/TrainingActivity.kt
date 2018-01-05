package com.aliak.dev.fastreading.ui.training

import android.view.Menu
import android.view.MenuItem
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.training.TrainingPresenter
import com.aliak.dev.fastreading.mvp.TrainingContract
import com.aliak.dev.fastreading.ui.base.BaseLifecycleThemedActivity
import kotlinx.android.synthetic.main.activity_training.*

/**
 * @author Aliaksandr Novik
 */
class TrainingActivity : BaseLifecycleThemedActivity<TrainingContract.Presenter>() {

    override fun initPresenter() = TrainingPresenter()

    override fun getResId(): Int = R.layout.activity_training

    override fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.training)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> presenter.navigateSettings(this@TrainingActivity)
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}