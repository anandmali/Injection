package com.anandmali.koin

import android.app.Application
import com.anandmali.koin.di.apiModule
import com.anandmali.koin.di.repositoryModule
import com.anandmali.koin.di.retrofitModule
import com.anandmali.koin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@KoinApplication)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }

}