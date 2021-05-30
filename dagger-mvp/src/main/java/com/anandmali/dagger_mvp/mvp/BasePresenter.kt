package com.anandmali.dagger_mvp.mvp

interface BasePresenter<T : BaseView> {
    
    fun onDestroy()
}