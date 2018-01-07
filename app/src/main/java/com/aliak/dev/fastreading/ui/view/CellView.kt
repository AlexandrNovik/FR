package com.aliak.dev.fastreading.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.aliak.dev.fastreading.R

/**
 * @author Aliaksandr Novik
 */
class CellView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_cell, this)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}