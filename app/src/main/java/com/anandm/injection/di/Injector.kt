package com.anandm.injection.di

import com.anandm.injection.search.SearchContract
import com.anandm.injection.search.SearchPresenterImpl

object Injector {

    private val retrofit = NetworkResolver.provideRetrofit()

    private val githubManager: GithubManager by lazy {
        ApplicationResolver.provideGithubManager(retrofit)
    }

    fun searchPresenter(view: SearchContract.View): SearchPresenterImpl {
        return ApplicationResolver.provideSearchPresenter(view, githubManager)
    }

}