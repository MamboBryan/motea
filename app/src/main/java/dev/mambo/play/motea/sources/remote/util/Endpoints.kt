package dev.mambo.play.motea.sources.remote.util

sealed class Endpoints(private val path: String) {

    val url: String
        get() = buildString {
            append("https://rickandmortyapi.com/api/")
            append(path)
        }

    data object Characters : Endpoints(path = "character")

    data class Character(val id: Int) : Endpoints(path = "character/$id")

}

enum class Endpoint(val path: String) {
    CHARACTERS(path = "characters"), CHARACTER(path = "character/id");

    val url: String
        get() = buildString {
            append("https://rickandmortyapi.com/api/")
            append(path)
        }
}
