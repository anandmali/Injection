package com.anandm.injection.di

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun someValue() = "Dependency Injection"

}