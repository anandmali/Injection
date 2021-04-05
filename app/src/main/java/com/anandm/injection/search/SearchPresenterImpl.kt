package com.anandm.injection.search

import com.anandm.injection.network.GithubManager
import javax.inject.Inject

class SearchPresenterImpl
@Inject constructor(
    private var view: SearchContract.View?,
    private var githubManager: GithubManager,
) : SearchContract.Presenter {

    fun fetchValue() {
        val value = githubManager.searchRepositories()
        view?.showMessage(value)
    }
}