package dev.mambo.play.motea.sources.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.mambo.play.motea.sources.remote.characters.CharacterRemoteSource
import dev.mambo.play.motea.sources.remote.characters.CharactersRemoteSourceImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


@Module
@InstallIn(SingletonComponent::class)
object RemoteProvider {

    @Provides
    fun providesHttpClient() = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = false
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }

    }

    @Provides
    fun providesCharactersRemoteSource(client: HttpClient): CharacterRemoteSource =
        CharactersRemoteSourceImpl(client)

}