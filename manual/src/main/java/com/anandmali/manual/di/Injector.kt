package com.anandmali.manual.di

import com.anandmali.manual.network.GithubManager
import com.anandmali.manual.search.SearchContract
import com.anandmali.manual.search.SearchPresenterImpl

object Injector {

    private val retrofit = NetworkResolver.provideRetrofit()

    private val githubManager: GithubManager by lazy {
        ApplicationResolver.provideGithubManager(retrofit)
    }

    fun searchPresenter(view: SearchContract.View): SearchPresenterImpl {
        return ApplicationResolver.provideSearchPresenter(view, githubManager)
    }

}