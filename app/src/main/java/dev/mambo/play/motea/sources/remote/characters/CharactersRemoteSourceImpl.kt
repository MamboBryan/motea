package dev.mambo.play.motea.sources.remote.characters

import dev.mambo.play.motea.sources.remote.dtos.CharactersResponse
import dev.mambo.play.motea.sources.remote.util.Endpoints
import dev.mambo.play.motea.sources.remote.util.NetworkResult
import dev.mambo.play.motea.sources.remote.util.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharactersRemoteSourceImpl(private val client: HttpClient) : CharacterRemoteSource {

    override suspend fun getCharacters(): NetworkResult<CharactersResponse> = safeApiCall {
        client.get(Endpoints.Characters.url).body()
    }

}