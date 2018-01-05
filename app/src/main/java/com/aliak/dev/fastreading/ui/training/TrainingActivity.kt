package com.aliak.dev.fastreading.ui.training

import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.training.TrainingItemsProvider
import com.aliak.dev.fastreading.domain.training.TrainingPresenter
import com.aliak.dev.fastreading.mvp.TrainingContract
import com.aliak.dev.fastreading.ui.base.BaseLifecycleThemedActivity
import kotlinx.android.synthetic.main.activity_training.*
import javax.inject.Inject

/**
 * @author Aliaksandr Novik
 */
class TrainingActivity : BaseLifecycleThemedActivity<TrainingContract.Presenter>() {

    init {
        FastReadingApp.appComponent.inject(this)
    }

    @Inject lateinit var dataProvider: TrainingItemsProvider
    override fun initPresenter() = TrainingPresenter()

    override fun getResId(): Int = R.layout.activity_training

    override fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.training)

        activity_training_list.adapter = TrainingAdapter(this,
                getAccentColor(),
                dataProvider.provideItems(this))
        activity_training_list.layoutManager = LinearLayoutManager(this)

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