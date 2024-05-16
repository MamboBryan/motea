package dev.mambo.play.motea.sources.remote.util

import timber.log.Timber

suspend fun <T> safeApiCall(errorMessage: String = "", block: suspend () -> T): NetworkResult<T> {
    return try {
        val data = block.invoke()
        Timber.d("Data -> $data")
        NetworkResult.Success(data = data)
    } catch (e: Exception) {
        Timber.e(e)
        NetworkResult.Error(message = e.localizedMessage ?: errorMessage, exception = e)
    }
}