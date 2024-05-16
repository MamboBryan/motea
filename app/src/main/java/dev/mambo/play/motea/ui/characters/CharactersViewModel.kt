package dev.mambo.play.motea.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.mambo.play.motea.data.characters.CharactersRepository
import dev.mambo.play.motea.data.models.CharacterDomain
import dev.mambo.play.motea.data.util.DataResult
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ListState<out T> {
    data object Loading : ListState<Nothing>
    data object Empty : ListState<Nothing>
    data class Error(val message: String) : ListState<Nothing>
    data class Success<T>(val list: List<T>) : ListState<T>
}

data class CharactersScreenState(
    val list: ListState<CharacterDomain> = ListState.Loading
)

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharactersRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersScreenState())
    val state get() = _state.asStateFlow()

    init {
        getCharacters()
    }

    fun onClickRetry() {
        getCharacters()
    }

    private var fetchJob: Job? = null
    private fun getCharacters() {
        if (fetchJob == null)
            fetchJob = viewModelScope.launch {
                val result = repository.getCharacters()
                val listState = when (result) {
                    is DataResult.Error -> ListState.Error(message = result.message)
                    is DataResult.Success -> {
                        val data = result.data
                        if (data.isEmpty())
                            ListState.Empty
                        else
                            ListState.Success(list = data)
                    }
                }

                _state.update { it.copy(list = listState) }
                fetchJob = null
            }
    }

}