package com.aliak.dev.fastreading.ui.training

import android.view.View
import com.aliak.dev.fastreading.data.TrainingModel
import com.aliak.dev.fastreading.ui.base.BaseAdapter
import kotlinx.android.synthetic.main.view_training_item.view.*

/**
 * @author Aliaksandr Novik
 */
class TrainingViewHolder(val view: View, val accentColor: Int) : BaseAdapter.AdapterViewHolder<TrainingModel>(view) {
    override fun bind(item: TrainingModel, position: Int) {
        view.training_item_text.text = item.title.toUpperCase()
        view.training_item_text.setTextColor(accentColor)
    }

    override fun init() {
    }

    override fun release() {
    }
}