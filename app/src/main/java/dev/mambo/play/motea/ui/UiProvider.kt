package dev.mambo.play.motea.ui

import dev.mambo.play.motea.ui.characters.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CharactersViewModel(repository = get()) }
//    viewMod
}

object UiProvider {
//    val charactersViewModel = CharactersViewModel(repository = DataProvider.charactersRepository)
}