package com.anandm.injection.search

import androidx.lifecycle.ViewModel
import com.anandm.injection.network.MutableStatus
import com.anandm.injection.network.SearchRepository
import com.anandm.injection.network.model.RepoModel
import com.anandm.injection.network.model.SearchModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel
@Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _searchStatus = MutableStatus<List<RepoModel>>()

    fun getSearchStatus() = _searchStatus

    private var job: Job = Job()

    private val backGroundScope = CoroutineScope(Dispatchers.IO)

    init {
        fetchValue()
    }

    private fun fetchValue() {
        _searchStatus postInFlight true
        job = backGroundScope.launch {
            searchRepository.fetchValues(::handlerError, ::handleResponse)
        }
    }

    private fun handleResponse(models: SearchModel) {
        _searchStatus postSuccess models.items
    }

    private fun handlerError(error: String) {
        _searchStatus postFailure error
    }
}