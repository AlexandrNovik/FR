package com.aliak.dev.fastreading.domain.training

import android.content.Context
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.data.TrainingModel
import com.aliak.dev.fastreading.data.TrainingModel.SchulteTraining
import com.aliak.dev.fastreading.mvp.TrainingContract
import com.aliak.dev.fastreading.routing.Router
import javax.inject.Inject

class TrainingPresenter : TrainingContract.Presenter() {
    @Inject lateinit var routerMain: Router.Main
    @Inject lateinit var routerTraining: Router.Training

    override fun itemClick(model: TrainingModel, context: Context) {
        when (model) {
            is SchulteTraining -> routerTraining.navigateSchulteDescription(context)
        }
    }

    init {
        FastReadingApp.appComponent.inject(this)
    }

    override fun navigateSettings(context: Context) {
        routerMain.navigateSettings(context)
    }
}