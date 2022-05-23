package com.anandmali.manual

import android.app.Application
import com.anandmali.manual.di.ApplicationResolver

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationResolver.initializeApp(this)
    }

}