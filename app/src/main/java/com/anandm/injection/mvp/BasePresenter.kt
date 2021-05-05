package com.anandm.injection.mvp

interface BasePresenter<T : BaseView> {
    
    fun onDestroy()

}