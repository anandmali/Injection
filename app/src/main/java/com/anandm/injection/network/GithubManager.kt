package com.anandm.injection.network

import com.anandm.injection.di.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class GithubManager
@Inject constructor(
    private val githubService: GithubService,
) {

    fun searchRepositories(): String {
        return "Some value from service"
//        return githubService.getRepositories("android").body().toString()
    }

}