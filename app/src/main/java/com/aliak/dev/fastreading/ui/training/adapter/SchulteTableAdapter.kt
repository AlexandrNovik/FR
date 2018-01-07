package com.aliak.dev.fastreading.ui.training.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.data.SchulteCellModel
import com.aliak.dev.fastreading.ui.base.BaseAdapter
import com.aliak.dev.fastreading.ui.training.holder.SchulteTableHolder

class SchulteTableAdapter(val context: Context, items: MutableList<SchulteCellModel>)
    : BaseAdapter<SchulteCellModel, SchulteTableHolder>(items) {
    override fun createHolder(parent: ViewGroup?, viewType: Int): SchulteTableHolder {
        return SchulteTableHolder(LayoutInflater.from(context)
                .inflate(R.layout.view_schulte_grid_item, parent, false))
    }
}