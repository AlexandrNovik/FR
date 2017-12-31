package com.aliak.dev.fastreading.di

import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.databinding.viewmodel.MainScreenViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, AnalyticsReporterModule::class])
interface AppComponent {
    fun inject(app: FastReadingApp)
    fun inject(viewModel: MainScreenViewModel)

}
