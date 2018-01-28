package com.aliak.dev.fastreading.domain

import android.content.Context
import android.content.Context.MODE_PRIVATE
import javax.inject.Singleton


const val KEY_SCHULTE_TABLE = "KEY_SCHULTE_TABLE"

@Singleton
class AppSharedPreferences(context: Context, name: String) {
    private val preferences = context.getSharedPreferences(name, MODE_PRIVATE)

    fun putSchulteTableValue(count: Int) {
        preferences.edit().putInt(KEY_SCHULTE_TABLE, count).apply()
    }

    fun getSchulteTableValue(): Int = preferences.getInt(KEY_SCHULTE_TABLE, 5)
}
