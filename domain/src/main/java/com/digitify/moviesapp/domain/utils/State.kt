package com.digitify.moviesapp.domain.utils


/**
 * State Management for UI & Data.
 */
sealed class State<out T> {

    class Loading<T>(data: T? = null) : State<T>()

    data class Success<T>(val wrapperData: T) : State<T>()

    data class DBSuccess<T>(val wrapperData: T) : State<T>()

    data class Error(val serverError: String) : State<Nothing>()

}
