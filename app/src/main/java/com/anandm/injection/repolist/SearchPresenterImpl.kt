package com.anandm.injection.repolist

import com.anandm.injection.network.GithubManager
import javax.inject.Inject

class SearchPresenterImpl
@Inject constructor(
    private var view: SearchContract.View?,
    private var githubManager: GithubManager,
) : SearchContract.Presenter {

    fun fetchValue() {
        val value = githubManager.someThing()
        view?.showMessage(value)
    }
}