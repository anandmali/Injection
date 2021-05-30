package com.anandmali.dagger_mvp.di.search

import com.anandmali.dagger_mvp.di.ActivityScoped
import com.anandmali.dagger_mvp.search.SearchActivity
import com.anandmali.dagger_mvp.search.SearchContract
import com.anandmali.dagger_mvp.di.search.SearchModule
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