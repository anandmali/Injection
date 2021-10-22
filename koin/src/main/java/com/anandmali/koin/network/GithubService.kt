package com.anandmali.koin.network

import com.anandmali.koin.network.model.SearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun getRepositories(@Query("q") query: String = "android"): Response<SearchModel>

}