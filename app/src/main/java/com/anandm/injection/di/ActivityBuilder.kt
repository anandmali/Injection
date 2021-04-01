package com.anandm.injection.di

import com.anandm.injection.repolist.MainActivity
import com.anandm.injection.repolist.RepoListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [
            RepoListModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity

}