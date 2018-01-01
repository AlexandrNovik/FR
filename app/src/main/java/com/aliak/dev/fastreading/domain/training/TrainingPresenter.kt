package com.aliak.dev.fastreading.domain.training

import android.content.Context
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.mvp.TrainingContract
import com.aliak.dev.fastreading.routing.Router
import javax.inject.Inject

class TrainingPresenter : TrainingContract.Presenter() {
    @Inject lateinit var router: Router.Main

    init {
        FastReadingApp.appComponent.inject(this)
    }

    override fun navigateSettings(context: Context) {
        router.navigateSettings(context)
    }
}