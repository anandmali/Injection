package com.anandm.injection.di

import com.anandm.injection.BaseApplication

object ApplicationResolver {

    private var baseApplication: BaseApplication? = null

    //An example of application context dependency provider
    private val application by lazy {
        requireNotNull(baseApplication)
    }

    fun initializeApp(application: BaseApplication) {
        baseApplication = application
    }

}