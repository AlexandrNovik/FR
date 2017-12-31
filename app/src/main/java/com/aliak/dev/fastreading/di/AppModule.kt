package com.aliak.dev.fastreading.di

import dagger.Module
import dagger.Provides
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Aliaksandr Novik
 */
@Module
class AppModule {
    @Provides
    @Singleton
    @Named("main_thread")
    fun providePostExecutionThread(): Scheduler = AndroidSchedulers.mainThread()
}