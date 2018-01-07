package com.aliak.dev.fastreading.mvp

import com.aliak.dev.fastreading.data.SchulteCellModel
import com.aliak.dev.fastreading.domain.LifecyclePresenter

/**
 * @author Aliaksandr Novik
 */
interface SchulteContract {
    abstract class Presenter : LifecyclePresenter {
        abstract fun generateSсhulteTable(): List<SchulteCellModel>
        override fun initialize() {

        }

        override fun resume() {

        }

        override fun pause() {

        }

        override fun release() {

        }

        abstract fun itemClick(it: SchulteCellModel?)
    }
}