package com.anandm.injection.di.search

import com.anandm.injection.di.ActivityScoped
import com.anandm.injection.repolist.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun contributeSearchActivity(): SearchActivity

}