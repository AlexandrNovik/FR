package com.aliak.dev.fastreading.ui.training.holder

import android.support.v4.content.ContextCompat
import android.view.View
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.data.SchulteCellModel
import com.aliak.dev.fastreading.domain.interaction.ObserveSchulteResultUseCase
import com.aliak.dev.fastreading.ui.base.BaseAdapter
import kotlinx.android.synthetic.main.view_cell.view.*
import rx.Observable
import rx.observers.Subscribers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * @author Aliaksandr Novik
 */
class SchulteTableHolder(val view: View) : BaseAdapter.AdapterViewHolder<SchulteCellModel>(view) {
    @Inject lateinit var observeSchulteResultUseCase: ObserveSchulteResultUseCase
    private var cellNumber: Int = 0
    private val appContext = view.context.applicationContext
    private val colorRed = ContextCompat.getColor(appContext, R.color.colorRed)
    private val colorGreen = ContextCompat.getColor(appContext, R.color.colorGreen)

    init {
        FastReadingApp.appComponent.inject(this)
    }

    override fun bind(item: SchulteCellModel, position: Int) {
        cellNumber = item.value
        view.cell_text.text = item.value.toString()
    }

    override fun init() {
        observeSchulteResultUseCase.execute(Unit, Subscribers.create {
            val (number, correct) = it
            if (number == cellNumber) {
                applyCellColor(correct)
            }
        })
    }

    private fun applyCellColor(correct: Boolean) {
        Observable
                .fromCallable {
                    view.cell_color.setBackgroundColor(if (correct) colorGreen else colorRed)
                    view.cell_color.background.alpha = 100
                }
                .flatMap { Observable.interval(300, TimeUnit.MILLISECONDS).first() }
                .subscribe {
                    view.cell_color.background.alpha = 0
                }
    }

    override fun release() {
        observeSchulteResultUseCase.unsubscribe()
    }
}