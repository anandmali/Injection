package com.anandmali.manual_injection

import android.app.Application
import com.anandmali.manual_injection.di.ApplicationResolver

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationResolver.initializeApp(this)
    }

}