package com.anandmali.hilt_mvvm.search

import androidx.lifecycle.ViewModel
import com.anandmali.hilt_mvvm.network.MutableStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

@HiltViewModel
class SearchViewModel : ViewModel() {

    private val _searchStatus = MutableStatus<Any>()

    fun getSearchStatus() = _searchStatus

    private var job: Job = Job()

    private val backGroundScope = CoroutineScope(Dispatchers.IO)

    init {
        fetchValue()
    }

    private fun fetchValue() {
        TODO("Fetch github response")
    }
}