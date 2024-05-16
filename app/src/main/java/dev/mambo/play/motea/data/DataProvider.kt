package dev.mambo.play.motea.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.mambo.play.motea.data.characters.CharactersRepository
import dev.mambo.play.motea.data.characters.CharactersRepositoryImpl
import dev.mambo.play.motea.sources.remote.characters.CharacterRemoteSource

@Module
@InstallIn(SingletonComponent::class)
object DataProvider {

    @Provides
    fun providesCharacterRepository(
        characterRemoteSource: CharacterRemoteSource
    ): CharactersRepository = CharactersRepositoryImpl(characterRemoteSource)

}