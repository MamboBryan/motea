package dev.mambo.play.motea.data

import dev.mambo.play.motea.data.characters.CharactersRepository
import dev.mambo.play.motea.data.characters.CharactersRepositoryImpl
import dev.mambo.play.motea.sources.remote.RemoteProvider

object DataProvider {

    val charactersRepository : CharactersRepository
        get() = CharactersRepositoryImpl(remoteSource = RemoteProvider.charactersRemoteSource)

}