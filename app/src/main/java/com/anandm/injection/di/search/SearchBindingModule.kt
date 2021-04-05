package com.anandm.injection.di.search

import com.anandm.injection.di.ActivityScoped
import com.anandm.injection.search.SearchActivity
import com.anandm.injection.search.SearchContract
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun contributeSearchActivity(): SearchActivity

    @ActivityScoped
    @Binds
    abstract fun provideView(searchActivity: SearchActivity): SearchContract.View

}