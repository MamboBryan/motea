package dev.mambo.play.motea.data.models

import dev.mambo.play.motea.sources.remote.dtos.CharacterDto

data class CharacterDomain(
    val id: Int?,
    val name: String,
    val gender: String,
    val species: String,
    val status: String,
    val image: String,
    val episode: ArrayList<String>,
)

fun CharacterDto.toDomain() = CharacterDomain(
    id = id,
    name = name ?: "",
    gender = gender ?: "",
    species = species ?: "",
    status = status ?: "",
    image = image ?: "",
    episode = episode
)
