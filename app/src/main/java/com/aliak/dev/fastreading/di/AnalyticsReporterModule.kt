package com.aliak.dev.fastreading.di

import android.app.Application
import com.aliak.dev.fastreading.analytics.AnalyticsReporter
import com.aliak.dev.fastreading.analytics.AnalyticsReporterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsReporterModule {
    @Singleton
    @Provides
    fun provideAnalyticsReporter(app: Application): AnalyticsReporter {
        return AnalyticsReporterImpl(app)
    }
}