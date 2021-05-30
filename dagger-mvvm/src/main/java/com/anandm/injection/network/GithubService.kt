package com.anandm.injection.network

import com.anandm.injection.network.model.SearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService{

    @GET("search/repositories")
    suspend fun getRepositories(@Query("q") query: String = "android"): Response<SearchModel>

}