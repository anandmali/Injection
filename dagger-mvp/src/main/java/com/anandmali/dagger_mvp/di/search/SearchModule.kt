package com.anandmali.dagger_mvp.di.search

import com.anandmali.dagger_mvp.di.ActivityScoped
import com.anandmali.dagger_mvp.network.GithubService
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