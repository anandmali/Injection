package com.anandm.injection.di.search

import com.anandm.injection.di.ActivityScoped
import com.anandm.injection.di.ViewModelsModule
import com.anandm.injection.search.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ViewModelsModule::class])
    abstract fun contributeSearchActivity(): SearchActivity

}