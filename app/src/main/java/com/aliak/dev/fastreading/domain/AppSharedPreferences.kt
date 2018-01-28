package com.aliak.dev.fastreading.domain

import android.content.Context
import android.content.Context.MODE_PRIVATE
import javax.inject.Singleton


const val KEY_SCHULTE_ROW = "KEY_SCHULTE_ROW"
const val KEY_SCHULTE_COLUMN = "KEY_SCHULTE_COLUMN"

@Singleton
class AppSharedPreferences(context: Context, name: String) {
    private val preferences = context.getSharedPreferences(name, MODE_PRIVATE)

    fun putSchulteRowValue(count: Int) {
        preferences.edit().putInt(KEY_SCHULTE_ROW, count).apply()
    }

    fun getSchulteRowValue(): Int = preferences.getInt(KEY_SCHULTE_ROW, 5)


    fun putSchulteColumnValue(count: Int) {
        preferences.edit().putInt(KEY_SCHULTE_COLUMN, count).apply()
    }

    fun getSchulteColumnValue(): Int = preferences.getInt(KEY_SCHULTE_COLUMN, 5)

}
