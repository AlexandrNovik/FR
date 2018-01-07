package com.aliak.dev.fastreading.ui.training.holder

import android.view.View
import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.data.SchulteCellModel
import com.aliak.dev.fastreading.ui.base.BaseAdapter
import kotlinx.android.synthetic.main.view_cell.view.*

/**
 * @author Aliaksandr Novik
 */
class SchulteTableHolder(val view: View) : BaseAdapter.AdapterViewHolder<SchulteCellModel>(view) {
    init {
        FastReadingApp.appComponent.inject(this)
    }
    override fun bind(item: SchulteCellModel, position: Int) {
        view.cell_text.text = item.value.toString()
        // TODO: observe schulte logic and change cell color transparent -> green or red -> transparent
        // view.cell_color
    }

    override fun init() {

    }

    override fun release() {

    }
}