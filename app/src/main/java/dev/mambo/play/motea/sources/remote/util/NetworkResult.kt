package dev.mambo.play.motea.sources.remote.util

sealed interface NetworkResult<out T> {
    data class Error(val message: String, val exception: Exception) : NetworkResult<Nothing>
    data class Success<T>(val data: T) : NetworkResult<T>
}
