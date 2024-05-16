package dev.mambo.play.motea.data.characters

import dev.mambo.play.motea.data.models.CharacterDomain
import dev.mambo.play.motea.data.util.DataResult

interface CharactersRepository {

    suspend fun getCharacters(): DataResult<List<CharacterDomain>>

}