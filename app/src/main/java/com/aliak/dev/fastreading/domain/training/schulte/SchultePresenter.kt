package com.aliak.dev.fastreading.domain.training.schulte

import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.data.SchulteCellModel
import com.aliak.dev.fastreading.domain.interaction.PickSchulteCellUseCase
import com.aliak.dev.fastreading.mvp.SchulteContract
import javax.inject.Inject

/**
 * @author Aliaksandr Novik
 */
class SchultePresenter : SchulteContract.Presenter() {
    init {
        FastReadingApp.appComponent.inject(this)
    }

    companion object {
        const val SCHULTE_SIZE = 25
    }

    @Inject lateinit var pickSchulteCellUseCase: PickSchulteCellUseCase

    override fun itemClick(model: SchulteCellModel?) {
        model?.let { pickSchulteCellUseCase.execute(it.value) }
    }

    override fun generateSсhulteTable(): List<SchulteCellModel> {
        val list = ArrayList<SchulteCellModel>()
        (1..SCHULTE_SIZE).mapTo(list) { SchulteCellModel(it) }
        return list.apply { shuffle() }
    }

}