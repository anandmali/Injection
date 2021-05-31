package com.anandmali.manual_injection.search

import com.anandmali.manual_injection.mvp.BasePresenter
import com.anandmali.manual_injection.mvp.BaseView
import com.anandmali.manual_injection.network.model.RepoModel

interface SearchContract {

    interface View : BaseView {
        fun updateList(list: List<RepoModel>)
    }

    interface Presenter : BasePresenter<View>

}