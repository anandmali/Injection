package com.anandm.injection.search

import com.anandm.injection.mvp.BasePresenter
import com.anandm.injection.mvp.BaseView
import com.anandm.injection.network.model.RepoModel

interface SearchContract {

    interface View : BaseView {
        fun updateList(list: List<RepoModel>)
    }

    interface Presenter : BasePresenter<View>

}