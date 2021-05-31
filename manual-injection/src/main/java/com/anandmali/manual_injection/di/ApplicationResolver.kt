package com.anandmali.manual_injection.di

import com.anandmali.manual_injection.BaseApplication
import com.anandmali.manual_injection.network.GithubManager
import com.anandmali.manual_injection.search.SearchContract
import com.anandmali.manual_injection.search.SearchPresenterImpl
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

    fun provideSearchPresenter(view: SearchContract.View, githubManager: GithubManager) =
        SearchPresenterImpl(view, githubManager)

    fun provideGithubManager(retrofit: Retrofit) = GithubManager(retrofit)

}