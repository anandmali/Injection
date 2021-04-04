package com.anandm.injection.network

import com.anandm.injection.di.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class GithubManager
@Inject constructor() {
    fun someThing() = "Service returned"
}