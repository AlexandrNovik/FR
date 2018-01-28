package com.aliak.dev.fastreading.domain.training.schulte

import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.data.SchulteCellModel
import com.aliak.dev.fastreading.domain.AppSharedPreferences
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

    @Inject lateinit var pickSchulteCellUseCase: PickSchulteCellUseCase
    @Inject lateinit var preferences: AppSharedPreferences

    override fun itemClick(model: SchulteCellModel?) {
        model?.let { pickSchulteCellUseCase.execute(it.value) }
    }

    override fun generateSсhulteTable(): List<SchulteCellModel> {
        val list = ArrayList<SchulteCellModel>()
        val schulteSize = getColumnCount() * preferences.getSchulteRowValue()
        (1..schulteSize).mapTo(list) { SchulteCellModel(it) }
        return list.apply { shuffle() }
    }

    override fun getColumnCount(): Int = preferences.getSchulteColumnValue()

}