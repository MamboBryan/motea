package dev.mambo.play.motea.data.characters

import dev.mambo.play.motea.data.models.CharacterDomain
import dev.mambo.play.motea.data.models.toDomain
import dev.mambo.play.motea.data.util.DataResult
import dev.mambo.play.motea.sources.remote.characters.CharacterRemoteSource
import dev.mambo.play.motea.sources.remote.util.NetworkResult

class CharactersRepositoryImpl(
    private val remoteSource: CharacterRemoteSource
) : CharactersRepository {

    override suspend fun getCharacters(): DataResult<List<CharacterDomain>> {
        return when (val result = remoteSource.getCharacters()) {
            is NetworkResult.Error -> DataResult.Error(message = result.message)
            is NetworkResult.Success -> DataResult.Success(data = result.data.results.map { it.toDomain() })
        }
    }

}