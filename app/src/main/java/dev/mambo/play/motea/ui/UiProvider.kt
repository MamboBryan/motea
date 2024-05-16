package dev.mambo.play.motea.ui

import dev.mambo.play.motea.data.DataProvider
import dev.mambo.play.motea.ui.characters.CharactersViewModel

object UiProvider {
    val charactersViewModel = CharactersViewModel(repository = DataProvider.charactersRepository)
}