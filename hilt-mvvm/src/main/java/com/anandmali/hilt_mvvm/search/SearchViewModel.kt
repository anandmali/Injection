package com.anandmali.hilt_mvvm.search

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.anandmali.hilt_mvvm.network.MutableStatus
import com.anandmali.hilt_mvvm.network.SearchRepository
import com.anandmali.hilt_mvvm.network.model.RepoModel
import com.anandmali.hilt_mvvm.network.model.SearchModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
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