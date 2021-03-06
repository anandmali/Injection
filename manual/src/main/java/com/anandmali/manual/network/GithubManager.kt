package com.anandmali.manual.network

import com.anandmali.manual.network.model.SearchModel
import io.reactivex.Flowable
import retrofit2.Retrofit

class GithubManager(
    private val retrofit: Retrofit,
) {

    private val githubService: GithubService by lazy {
        retrofit.create(GithubService::class.java)
    }

    fun searchRepositories(): Flowable<SearchModel> {
        return githubService.getRepositories("android")
    }

}