package com.yandey.pokedex.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.data.repository.monster.MonsterRepository
import com.yandey.pokedex.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MonsterRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Monster>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Monster>>> get() = _uiState
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        viewModelScope.launch {
            _query.value = newQuery
            repository.searchMonsters(_query.value)
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { monsters ->
                    _uiState.value = UiState.Success(monsters)
                }
        }
    }
}