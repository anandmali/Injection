package com.anandm.injection.network.model

import androidx.annotation.StringRes

sealed class Status<out R> {

    data class Success<out R>(val data: R) : Status<R>()

    data class Error(val message: String? = null) : Status<Nothing>()

    data class IsInFlight(@StringRes val message: Int? = null) : Status<Nothing>()
}