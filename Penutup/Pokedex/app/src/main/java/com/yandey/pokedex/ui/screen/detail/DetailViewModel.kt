package com.yandey.pokedex.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.data.repository.monster.MonsterRepository
import com.yandey.pokedex.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("unused")
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val monsterRepository: MonsterRepository,
) : ViewModel() {

    private val _monster = MutableStateFlow<UiState<Monster>>(UiState.Loading)
    val monster = _monster.asStateFlow()

    fun getFavoriteStateMonsterFromDB(id: Long) {
        viewModelScope.launch {
            monsterRepository.getFavoriteStateMonsterFromDB(id)
                .catch {
                    _monster.value = UiState.Error(it.message.toString())
                }
                .collect { monster ->
                    _monster.value = UiState.Success(monster)
                }
        }
    }

    fun updateFavoriteMonsterFromDB(id: Long, isFavorite: Boolean) {
        viewModelScope.launch {
            monsterRepository.updateFavoriteMonsterFromDB(id, isFavorite)
        }
    }
}