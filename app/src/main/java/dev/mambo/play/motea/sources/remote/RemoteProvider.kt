package dev.mambo.play.motea.sources.remote

import dev.mambo.play.motea.sources.remote.characters.CharacterRemoteSource
import dev.mambo.play.motea.sources.remote.characters.CharactersRemoteSourceImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object RemoteProvider {

    private val httpClient: HttpClient
        get() = HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    encodeDefaults = false
                    ignoreUnknownKeys = true
                })
            }
        }

    val charactersRemoteSource : CharacterRemoteSource
        get() = CharactersRemoteSourceImpl(client = httpClient)

}