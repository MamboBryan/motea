package dev.mambo.play.motea.data.util

sealed interface DataResult<out T> {

    data class Error(val message: String) : DataResult<Nothing>

    data class Success<T>(val data: T) : DataResult<T>

}