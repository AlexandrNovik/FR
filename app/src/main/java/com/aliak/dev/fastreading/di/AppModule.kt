package com.aliak.dev.fastreading.di

import android.app.Application
import android.content.Context
import com.aliak.dev.fastreading.domain.AppSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(app: Application) {
    private val application = app

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideApplicationContext(app: Application): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): AppSharedPreferences {
        return AppSharedPreferences(context, context.packageName)
    }
}