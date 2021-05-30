package com.anandmali.dagger_mvp.network

import com.anandmali.dagger_mvp.di.ActivityScoped
import com.anandmali.dagger_mvp.network.model.SearchModel
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