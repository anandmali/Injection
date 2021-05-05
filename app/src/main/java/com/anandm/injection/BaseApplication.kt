package com.anandm.injection

import android.app.Application
import com.anandm.injection.di.ApplicationResolver

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationResolver.initializeApp(this)
    }

}