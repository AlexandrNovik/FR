package com.aliak.dev.fastreading.ui.training

import android.support.v7.widget.GridLayoutManager
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.domain.training.SchultePresenter
import com.aliak.dev.fastreading.mvp.SchulteContract
import com.aliak.dev.fastreading.ui.base.BaseLifecycleThemedActivity
import com.aliak.dev.fastreading.ui.training.adapter.SchulteTableAdapter
import kotlinx.android.synthetic.main.activity_training_schulte.*
import rx.subscriptions.CompositeSubscription

/**
 * @author Aliaksandr Novik
 */
class SchulteActivity : BaseLifecycleThemedActivity<SchulteContract.Presenter>() {
    private val subscription = CompositeSubscription()

    override fun initPresenter(): SchulteContract.Presenter = SchultePresenter()

    override fun initView() {
        schulte_grid.adapter = SchulteTableAdapter(this,
                presenter.generateSсhulteTable().toMutableList())
        schulte_grid.layoutManager = GridLayoutManager(this, 5)
    }

    override fun getResId(): Int = R.layout.activity_training_schulte

    override fun onResume() {
        super.onResume()
        val cellClickSub = (schulte_grid.adapter as SchulteTableAdapter)
                .observeClickedItem()
                .subscribe({ presenter.itemClick(it) })
        subscription.add(cellClickSub)
    }

    override fun onPause() {
        super.onPause()
        subscription.clear()
    }
}