package com.anandm.injection.repolist

import com.anandm.injection.mvp.BasePresenter
import com.anandm.injection.mvp.BaseView

interface RepoContract {

    interface View : BaseView {

    }

    interface Presenter: BasePresenter<View> {

        fun something(): String

    }

}