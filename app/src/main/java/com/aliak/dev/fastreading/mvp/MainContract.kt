package com.aliak.dev.fastreading.mvp

import android.content.Context
import com.aliak.dev.fastreading.domain.LifecyclePresenter

/**
 * @author Aliaksandr Novik
 */
interface MainContract {
    interface View
    abstract class Presenter : LifecyclePresenter {
        abstract fun navigateTraining(context: Context)
        abstract fun navigateTrainingProgram(context: Context)
        abstract fun navigateReading(context: Context)
        abstract fun navigateMotivation(context: Context)
        abstract fun navigateSettings(context: Context)
        override fun initialize() {
        }

        override fun resume() {
        }

        override fun pause() {
        }

        override fun release() {
        }

    }
}