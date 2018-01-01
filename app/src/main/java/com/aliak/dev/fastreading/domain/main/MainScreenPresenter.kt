package com.aliak.dev.fastreading.domain.main

import android.content.Context
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.mvp.MainContract
import com.aliak.dev.fastreading.routing.Router
import javax.inject.Inject

class MainScreenPresenter : MainContract.Presenter() {
    @Inject lateinit var router: Router.Main

    init {
        FastReadingApp.appComponent.inject(this)
    }

    override fun navigateSettings(context: Context) {
        router.navigateSettings(context)
    }

    override fun navigateTraining(context: Context) {
        router.navigateTraining(context)
    }

    override fun navigateTrainingProgram(context: Context) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateReading(context: Context) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateMotivation(context: Context) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}