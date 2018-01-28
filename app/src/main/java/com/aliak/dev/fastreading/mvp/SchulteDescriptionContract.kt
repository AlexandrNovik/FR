package com.aliak.dev.fastreading.mvp

import android.content.Context
import com.aliak.dev.fastreading.domain.LifecyclePresenter

/**
 * @author Aliaksandr Novik
 */
interface SchulteDescriptionContract {
    interface View {
        fun setSettingsButtonsColorWithAlpha(alpha: Float)
        fun setStartButtonColorWithAlpha(alpha: Float)
        fun setSelectedButtonColorWithAlpha(button: SchulteSettingsButton, alpha: Float)
    }

    abstract class Presenter : LifecyclePresenter {

        override fun initialize() {}

        override fun resume() {}

        override fun pause() {}

        override fun release() {}

        abstract fun click(button5x5: SchulteSettingsButton)

        abstract fun start(context: Context)
    }

    sealed class SchulteSettingsButton(val size: Int) {
        class Button5x5 : SchulteSettingsButton(5)
        class Button6x6 : SchulteSettingsButton(6)
        class Button7x7 : SchulteSettingsButton(7)
        class Button8x8 : SchulteSettingsButton(8)
    }
}

