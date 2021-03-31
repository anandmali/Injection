package com.anandm.injection.di

import com.anandm.injection.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}