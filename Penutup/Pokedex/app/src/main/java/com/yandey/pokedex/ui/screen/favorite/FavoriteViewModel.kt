package com.yandey.pokedex.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.data.repository.monster.MonsterRepository
import com.yandey.pokedex.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val monsterRepository: MonsterRepository,
) : ViewModel() {

    init {
        getAllFavoriteMonstersFromDB()
    }

    private val _monsters = MutableStateFlow<UiState<List<Monster>>>(UiState.Loading)
    val monsters = _monsters.asStateFlow()

    private fun getAllFavoriteMonstersFromDB() {
        viewModelScope.launch {
            monsterRepository.getAllFavoriteMonstersFromDB()
                .catch {
                    _monsters.value = UiState.Error(it.message.toString())
                }
                .collect { monsters ->
                    _monsters.value = UiState.Success(monsters)
                }
        }
    }
}