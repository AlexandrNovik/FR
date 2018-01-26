package com.aliak.dev.fastreading.di

import com.aliak.dev.fastreading.domain.executor.JobExecutor
import com.aliak.dev.fastreading.domain.executor.PostExecutionThread
import com.aliak.dev.fastreading.domain.executor.ThreadExecutor
import com.aliak.dev.fastreading.domain.executor.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
open class AppModule {

    @Provides
    @Singleton
    fun provideThreadExecutor(): ThreadExecutor {
        return JobExecutor()
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(): PostExecutionThread {
        return UIThread()
    }
}