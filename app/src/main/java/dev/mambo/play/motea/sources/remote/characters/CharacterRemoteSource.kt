package dev.mambo.play.motea.sources.remote.characters

import dev.mambo.play.motea.sources.remote.dtos.CharactersResponse
import dev.mambo.play.motea.sources.remote.util.NetworkResult

interface CharacterRemoteSource {

    suspend fun getCharacters(): NetworkResult<CharactersResponse>

}