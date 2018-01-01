package com.aliak.dev.fastreading.di

import com.aliak.dev.fastreading.FastReadingApp
import com.aliak.dev.fastreading.domain.main.MainScreenPresenter
import com.aliak.dev.fastreading.domain.training.TrainingPresenter
import com.aliak.dev.fastreading.routing.MainRouter
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
        modules = [
        AppModule::class,
        AnalyticsReporterModule::class,
        RouterModule::class
        ])
interface AppComponent {
    fun inject(app: FastReadingApp)
    fun inject(presenter: MainScreenPresenter)
    fun inject(presenter: TrainingPresenter)
    fun inject(router: MainRouter)


}
