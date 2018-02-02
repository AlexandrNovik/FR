package com.aliak.dev.fastreading.domain.training.schulte

import android.content.Context
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.data.SchulteCellModel
import com.aliak.dev.fastreading.domain.AppSharedPreferences
import com.aliak.dev.fastreading.domain.base.UseCase
import com.aliak.dev.fastreading.domain.interaction.ObserveSchulteFinishUseCase
import com.aliak.dev.fastreading.domain.interaction.SchultePickCellUseCase
import com.aliak.dev.fastreading.domain.interaction.SchulteResetUseCase
import com.aliak.dev.fastreading.mvp.SchulteContract
import com.aliak.dev.fastreading.routing.Router
import javax.inject.Inject

/**
 * @author Aliaksandr Novik
 */
class SchultePresenter(var view: SchulteContract.View?) : SchulteContract.Presenter() {
    init {
        FastReadingApp.appComponent.inject(this)
    }

    @Inject lateinit var schultePickCellUseCase: SchultePickCellUseCase
    @Inject lateinit var observeSchulteFinishUseCase: ObserveSchulteFinishUseCase
    @Inject lateinit var schulteResetUseCase: SchulteResetUseCase
    @Inject lateinit var preferences: AppSharedPreferences
    @Inject lateinit var router: Router.Training
    @Inject lateinit var context: Context

    override fun initialize() {
        observeSchulteFinishUseCase.execute(Unit, UseCase.UseCaseSubscriber({
            router.navigateSchulteResult(context)
            view?.close()
        }))
    }

    override fun release() {
        schulteResetUseCase.execute(Unit)
        observeSchulteFinishUseCase.unsubscribe()
        view = null
    }

    override fun itemClick(model: SchulteCellModel?) {
        model?.let { schultePickCellUseCase.execute(it.value) }
    }

    override fun generateSсhulteTable(): List<SchulteCellModel> {
        val list = ArrayList<SchulteCellModel>()
        val schulteSize = Math.pow(getSchulteSize().toDouble(), 2.toDouble())
        (1..schulteSize.toInt()).mapTo(list) { SchulteCellModel(it) }
        return list.apply { shuffle() }
    }

    override fun getSchulteSize(): Int = preferences.getSchulteTableValue()

}