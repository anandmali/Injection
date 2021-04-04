package com.anandm.injection.saerch

import com.anandm.injection.mvp.BasePresenter
import com.anandm.injection.mvp.BaseView

interface SearchContract {

    interface View : BaseView {
        fun showMessage(message: String)
    }

    interface Presenter : BasePresenter<View>

}