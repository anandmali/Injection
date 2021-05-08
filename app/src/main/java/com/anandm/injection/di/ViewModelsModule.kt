package com.anandm.injection.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anandm.injection.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    abstract fun bindAppViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

}