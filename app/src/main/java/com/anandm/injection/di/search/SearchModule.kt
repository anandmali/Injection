package com.anandm.injection.di.search

import com.anandm.injection.di.ActivityScoped
import com.anandm.injection.network.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class SearchModule {

    @ActivityScoped
    @Provides
    fun providesGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

}