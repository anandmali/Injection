package com.anandm.injection.network

import com.anandm.injection.network.model.SearchModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService{

    @GET("search/repositories")
    fun getRepositories(@Query("q") query: String = "android"): Flowable<SearchModel>

}