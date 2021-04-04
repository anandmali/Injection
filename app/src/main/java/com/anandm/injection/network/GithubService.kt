package com.anandm.injection.network

import com.anandm.injection.network.model.SearchModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

interface GithubService {

    @GET("search/repositories")
    fun getRepositories(@Query("q") query: String = "android"): Response<SearchModel>

}