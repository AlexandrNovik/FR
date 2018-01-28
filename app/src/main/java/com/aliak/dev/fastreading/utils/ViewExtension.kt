package com.aliak.dev.fastreading.utils

import android.view.View

fun View.click(body: () -> Unit) {
    this.setOnClickListener { body() }
}
