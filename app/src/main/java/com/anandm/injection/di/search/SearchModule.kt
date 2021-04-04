package com.anandm.injection.di.search

import com.anandm.injection.di.ActivityScoped
import com.anandm.injection.repolist.SearchContract
import com.anandm.injection.repolist.SearchActivity
import dagger.Binds
import dagger.Module

@Module
abstract class SearchModule {

    @ActivityScoped
    @Binds
    abstract fun provideView(searchActivity: SearchActivity): SearchContract.View

}