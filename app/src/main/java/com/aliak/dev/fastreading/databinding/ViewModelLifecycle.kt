package com.aliak.dev.fastreading.databinding

interface ViewModelLifecycle {
    fun initialize()
    fun resume()
    fun pause()
    fun release()
}