package com.aliak.dev.fastreading.mvp

import android.content.Context
import com.aliak.dev.fastreading.domain.LifecyclePresenter

/**
 * @author Aliaksandr Novik
 */
interface TrainingContract {
    interface View
    abstract class Presenter : LifecyclePresenter {
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