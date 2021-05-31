package com.anandmali.manual_injection.mvp

interface BasePresenter<T : BaseView> {
    
    fun onDestroy()

}