package com.anandm.injection.repolist

import com.anandm.injection.di.ActivityScoped
import dagger.Module
import dagger.Provides

@Module
class RepoListModule {

    @ActivityScoped
    @Provides
    fun providePresenter(): RepoPresenterImpl = RepoPresenterImpl()

}