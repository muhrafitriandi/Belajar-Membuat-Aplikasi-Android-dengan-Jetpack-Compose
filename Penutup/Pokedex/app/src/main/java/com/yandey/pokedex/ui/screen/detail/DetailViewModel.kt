package com.yandey.pokedex.ui.screen.detail

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
class DetailViewModel @Inject constructor(
    private val repository: MonsterRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<Monster>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Monster>> get() = _uiState

    fun getMonsterById(id: Long) {
        viewModelScope.launch {
            repository.getMonsterById(id)
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { monsters ->
                    _uiState.value = UiState.Success(monsters)
                }
        }
    }
}