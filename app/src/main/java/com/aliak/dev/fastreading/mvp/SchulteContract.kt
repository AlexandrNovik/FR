package com.aliak.dev.fastreading.mvp

import com.aliak.dev.fastreading.domain.LifecyclePresenter

/**
 * @author Aliaksandr Novik
 */
interface SchulteContract {
    abstract class Presenter : LifecyclePresenter {
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