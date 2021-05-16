package io.github.haniyehkhaksar.dbexample.utils

sealed class MyResult<T> (
    val data: T? = null,
    val error: Throwable? = null) {

    class Success<T>(data: T) : MyResult<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : MyResult<T>(data, throwable)

}