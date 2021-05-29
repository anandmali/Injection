package com.anandm.injection.di

import com.anandm.injection.BaseApplication
import com.anandm.injection.search.SearchContract
import com.anandm.injection.search.SearchPresenterImpl
import retrofit2.Retrofit

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