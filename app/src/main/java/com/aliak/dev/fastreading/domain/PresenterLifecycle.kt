package com.aliak.dev.fastreading.domain

interface PresenterLifecycle {
    fun initialize()
    fun resume()
    fun pause()
    fun release()
}