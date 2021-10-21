package com.anandmali.dagger_mvp.search

import com.anandmali.dagger_mvp.mvp.BasePresenter
import com.anandmali.dagger_mvp.mvp.BaseView
import com.anandmali.dagger_mvp.network.model.RepoModel

interface SearchContract {

    interface View : BaseView {
        fun updateList(list: List<RepoModel>)
    }

    interface Presenter : BasePresenter<View>

}