package com.anandm.injection.repolist

class RepoPresenterImpl : RepoContract.Presenter {

    override fun something() = "some thing"

    private var view: RepoContract.View? = null

    override fun viewAttached(view: RepoContract.View) {
        this.view = view
    }

    override fun viewDetached() {
        this.view = null
    }
}