package com.aliak.dev.fastreading.domain.training

import com.aliak.dev.fastreading.data.SchulteCellModel
import com.aliak.dev.fastreading.mvp.SchulteContract

/**
 * @author Aliaksandr Novik
 */
class SchultePresenter : SchulteContract.Presenter() {
    companion object {
        const val SCHULTE_SIZE = 25
    }

    override fun itemClick(it: SchulteCellModel?) {
        // TODO: main schulte logic
    }

    override fun generateSсhulteTable(): List<SchulteCellModel> {
        val list = ArrayList<SchulteCellModel>()
        (1..SCHULTE_SIZE).mapTo(list) { SchulteCellModel(it) }
        return list.apply { shuffle() }
    }

}