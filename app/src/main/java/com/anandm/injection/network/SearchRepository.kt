package com.anandm.injection.network

import com.anandm.injection.network.model.SearchModel
import javax.inject.Inject

class SearchRepository
@Inject constructor(
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