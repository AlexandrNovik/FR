package com.aliak.dev.fastreading.di

import com.aliak.dev.fastreading.FastReadingApp
import dagger.Component
import javax.inject.Singleton

/**
 * @author Alexander Novik
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(app: FastReadingApp)
}