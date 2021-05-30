package com.anandm.dagger_mvvm.di.search

import com.anandm.dagger_mvvm.di.ActivityScoped
import com.anandm.dagger_mvvm.di.ViewModelsModule
import com.anandm.dagger_mvvm.search.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ViewModelsModule::class])
    abstract fun contributeSearchActivity(): SearchActivity

}