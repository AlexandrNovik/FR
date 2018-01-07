package com.aliak.dev.fastreading.domain.view

import com.aliak.dev.fastreading.mvp.CellContract

/**
 * @author Aliaksandr Novik
 */
class CellPresenter : CellContract.Presenter {
    private var number = 0
    override fun setNumber(number: Int) {
        this.number = number
    }

    override fun init() {
    }

    override fun release() {
    }
}