package com.aliak.dev.fastreading.domain

interface LifecyclePresenter {
    fun initialize()
    fun resume()
    fun pause()
    fun release()
}