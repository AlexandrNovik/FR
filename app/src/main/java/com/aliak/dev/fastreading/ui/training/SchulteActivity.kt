package com.aliak.dev.fastreading.ui.training

import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.training.SchultePresenter
import com.aliak.dev.fastreading.mvp.SchulteContract
import com.aliak.dev.fastreading.ui.base.BaseLifecycleThemedActivity

/**
 * @author Aliaksandr Novik
 */
class SchulteActivity : BaseLifecycleThemedActivity<SchulteContract.Presenter>() {
    override fun initPresenter(): SchulteContract.Presenter = SchultePresenter()

    override fun initView() {
    }

    override fun getResId(): Int = R.layout.activity_training_schulte
}