package com.aliak.dev.fastreading.ui.training

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.data.TrainingModel
import com.aliak.dev.fastreading.ui.base.BaseAdapter

/**
 * @author Aliaksandr Novik
 */
class TrainingAdapter(private val context: Context,
                      private val accentColor: Int,
                      items: MutableList<TrainingModel>)
    : BaseAdapter<TrainingModel, TrainingViewHolder>(items) {
    override fun createHolder(parent: ViewGroup?, viewType: Int): TrainingViewHolder =
            TrainingViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.view_training_item, parent, false),
                    accentColor)
}