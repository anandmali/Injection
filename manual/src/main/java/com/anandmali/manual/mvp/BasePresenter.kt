package com.anandmali.manual.mvp

interface BasePresenter<T : BaseView> {
    
    fun onDestroy()

}