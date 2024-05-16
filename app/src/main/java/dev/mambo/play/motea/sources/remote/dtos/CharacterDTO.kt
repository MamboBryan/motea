package dev.mambo.play.motea.sources.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    @SerialName("info") val info: Info? = Info(),
    @SerialName("results") val results: ArrayList<CharacterDto> = arrayListOf()
)

@Serializable
data class Info(
    @SerialName("count") val count: Int? = null,
    @SerialName("pages") val pages: Int? = null,
    @SerialName("next") val next: String? = null,
    @SerialName("prev") val prev: String? = null
)

@Serializable
data class OriginDto(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null
)

@Serializable
data class LocationDto(
    @SerialName("name") val name: String? = null,
    @SerialName("url") val url: String? = null
)

@Serializable
data class CharacterDto(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("species") val species: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("gender") val gender: String? = null,
    @SerialName("origin") val origin: OriginDto? = OriginDto(),
    @SerialName("location") val location: LocationDto? = LocationDto(),
    @SerialName("image") val image: String? = null,
    @SerialName("episode") val episode: ArrayList<String> = arrayListOf(),
    @SerialName("url") val url: String? = null,
    @SerialName("created") val created: String? = null
)
