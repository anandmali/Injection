package com.anandm.injection.di

import com.anandm.injection.network.GithubService
import com.anandm.injection.network.model.SearchModel
import io.reactivex.Flowable
import javax.inject.Inject

@ActivityScoped
class GithubManager
@Inject constructor(
    private val githubService: GithubService,
) {

    fun searchRepositories(): Flowable<SearchModel> {
        return githubService.getRepositories("android")
    }

}