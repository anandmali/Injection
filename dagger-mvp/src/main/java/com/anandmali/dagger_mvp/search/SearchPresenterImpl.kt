package com.anandmali.dagger_mvp.search

import android.util.Log
import com.anandmali.dagger_mvp.network.GithubManager
import com.anandmali.dagger_mvp.network.model.SearchModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchPresenterImpl
@Inject constructor(
    private var view: SearchContract.View?,
    private var githubManager: GithubManager,
) : SearchContract.Presenter {

    private var compositeDisposable = CompositeDisposable()

    fun fetchValue() {

        val disposable: Disposable = githubManager.searchRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse, this::handlerError)

        compositeDisposable.add(disposable)
    }

    private fun handleResponse(model: SearchModel) {
        view?.updateList(model.items)
    }

    private fun handlerError(error: Throwable) {
        Log.e("handlerError ", error.localizedMessage)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

}