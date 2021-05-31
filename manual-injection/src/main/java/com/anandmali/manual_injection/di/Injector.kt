package com.anandmali.manual_injection.di

import com.anandmali.manual_injection.network.GithubManager
import com.anandmali.manual_injection.search.SearchContract
import com.anandmali.manual_injection.search.SearchPresenterImpl

object Injector {

    private val retrofit = NetworkResolver.provideRetrofit()

    private val githubManager: GithubManager by lazy {
        ApplicationResolver.provideGithubManager(retrofit)
    }

    fun searchPresenter(view: SearchContract.View): SearchPresenterImpl {
        return ApplicationResolver.provideSearchPresenter(view, githubManager)
    }

}