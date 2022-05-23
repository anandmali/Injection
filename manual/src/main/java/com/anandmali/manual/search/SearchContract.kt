package com.anandmali.manual.search

import com.anandmali.manual.mvp.BasePresenter
import com.anandmali.manual.mvp.BaseView
import com.anandmali.manual.network.model.RepoModel

interface SearchContract {

    interface View : BaseView {
        fun updateList(list: List<RepoModel>)
    }

    interface Presenter : BasePresenter<View>

}