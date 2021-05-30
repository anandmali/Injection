package com.anandm.dagger_mvvm.di.search

import com.anandm.dagger_mvvm.di.ActivityScoped
import com.anandm.dagger_mvvm.network.GithubService
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