package utils

import android.view.View

fun View.click(body: () -> Unit) {
    this.setOnClickListener { body() }
}
