package com.anandmali.commits.repository.remot

import androidx.annotation.IntegerRes
import androidx.lifecycle.MutableLiveData

sealed class Status<out R> {

    data class Success<R>(val data: R) : Status<R>()

    data class Error(
        val message: String? = null,
        @IntegerRes val id: Int? = null
    ) : Status<Nothing>()

    data class IsInFlight(val loading: Boolean = false) : Status<Nothing>()
}

class MutableStatus<R> : MutableLiveData<Status<R>>() {

    override infix fun postValue(value: Status<R>?) {
        super.postValue(value)
    }

    infix fun postSuccess(data: R) {
        postValue(Status.Success(data))
    }

    infix fun postFailure(message: String?) {
        postValue(Status.Error(message = message))
    }

    infix fun postFailure(messageId: Int?) {
        postValue(Status.Error(id = messageId))
    }

    infix fun postInFlight(loading: Boolean) {
        postValue(Status.IsInFlight(loading))
    }

    fun clear() {
        postValue(null)
    }
}