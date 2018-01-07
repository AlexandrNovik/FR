package com.aliak.dev.fastreading.mvp

/**
 * @author Aliaksandr Novik
 */
interface CellContract {
    interface View {
        fun setNumber(number: Int)
    }

    interface Presenter {
        fun init()
        fun release()
        fun setNumber(number: Int)
    }
}