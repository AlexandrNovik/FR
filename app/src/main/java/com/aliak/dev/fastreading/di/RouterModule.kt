package com.aliak.dev.fastreading.di

import com.aliak.dev.fastreading.routing.MainRouter
import com.aliak.dev.fastreading.routing.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RouterModule {
    @Singleton
    @Provides
    fun provideRouterMain(): Router.Main {
        return MainRouter()
    }
}