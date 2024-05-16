package dev.mambo.play.motea.sources.remote.util

sealed class Endpoints(private val path: String) {

    val url: String
        get() = buildString {
            append("https://rickandmortyapi.com/api/")
            append(path)
        }

    data object Characters : Endpoints(path = "characters")

    data class Character(val id: Int) : Endpoints(path = "characters/$id")

}