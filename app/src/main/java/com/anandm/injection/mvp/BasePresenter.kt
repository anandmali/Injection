package com.anandm.injection.mvp

interface BasePresenter<T : BaseView> {

    fun viewAttached(view: T)

    fun viewDetached()

}