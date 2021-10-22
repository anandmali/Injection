package com.anandmali.koin.network

import com.anandmali.koin.network.model.SearchModel

class SearchRepository(
    private val githubService: GithubService
) {

    suspend fun fetchValues(
        handleError: (error: String) -> Unit,
        handleSuccess: (models: SearchModel) -> Unit
    ) {
        val response = githubService.getRepositories()

        if (response.isSuccessful) {
            response.body()?.let(handleSuccess)
        } else {
            response.message().let(handleError)
        }
    }
}