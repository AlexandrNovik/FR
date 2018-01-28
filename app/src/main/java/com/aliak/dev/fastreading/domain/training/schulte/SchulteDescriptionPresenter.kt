package com.aliak.dev.fastreading.domain.training.schulte

import android.content.Context
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.domain.AppSharedPreferences
import com.aliak.dev.fastreading.mvp.SchulteDescriptionContract
import com.aliak.dev.fastreading.mvp.SchulteDescriptionContract.SchulteSettingsButton.*
import com.aliak.dev.fastreading.routing.Router
import javax.inject.Inject

const val ALPHA_COMMON = 100F
const val ALPHA_UNSELECTED = 160F

class SchulteDescriptionPresenter(var view: SchulteDescriptionContract.View?) :
        SchulteDescriptionContract.Presenter() {

    init {
        FastReadingApp.appComponent.inject(this)
    }

    @Inject lateinit var preferences: AppSharedPreferences
    @Inject lateinit var router: Router.Training

    override fun resume() {
        view?.setSettingsButtonsColorWithAlpha(ALPHA_UNSELECTED)
        view?.setStartButtonColorWithAlpha(ALPHA_COMMON)

        setSelectedButton(preferences.getSchulteTableValue())
    }

    override fun release() {
        view = null
    }

    override fun click(button: SchulteDescriptionContract.SchulteSettingsButton) {
        preferences.putSchulteTableValue(button.size)
        view?.setSettingsButtonsColorWithAlpha(ALPHA_UNSELECTED)
        view?.setSelectedButtonColorWithAlpha(button, ALPHA_COMMON)
    }

    private fun setSelectedButton(size: Int) {
        when (size) {
            5 -> view?.setSelectedButtonColorWithAlpha(Button5x5(), ALPHA_COMMON)
            6 -> view?.setSelectedButtonColorWithAlpha(Button6x6(), ALPHA_COMMON)
            7 -> view?.setSelectedButtonColorWithAlpha(Button7x7(), ALPHA_COMMON)
            8 -> view?.setSelectedButtonColorWithAlpha(Button8x8(), ALPHA_COMMON)
        }

    }

    override fun start(context: Context) {
        router.navigateSchulteTraining(context)
    }
}