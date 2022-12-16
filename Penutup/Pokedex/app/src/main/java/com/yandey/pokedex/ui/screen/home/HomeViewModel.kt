package com.yandey.pokedex.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandey.pokedex.data.FakeMonsterDataSource
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.data.repository.monster.MonsterRepository
import com.yandey.pokedex.ui.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val monsterRepository: MonsterRepository,
) : ViewModel() {

    init {
        getAllMonstersFromDB()
    }

    private val _monsters = MutableStateFlow<UiState<List<Monster>>>(UiState.Loading)
    val monsters = _monsters.asStateFlow()

    private val _query = mutableStateOf("")
    val query: State<String> = _query

    private fun getAllMonstersFromDB() {
        viewModelScope.launch {
            monsterRepository.getAllMonstersFromDB()
                .catch {
                    _monsters.value = UiState.Error(it.message.toString())
                }
                .collect { monsters ->
                    if (monsters.isNotEmpty()) {
                        _monsters.value = UiState.Success(monsters)
                    } else {
                        monsterRepository.insertMonstersToDB(FakeMonsterDataSource.dummyMonster)
                    }
                }
        }
    }

    fun searchMonstersFromDB(newQuery: String) {
        viewModelScope.launch {
            _query.value = newQuery
            monsterRepository.searchMonstersFromDB(_query.value)
                .catch {
                    _monsters.value = UiState.Error(it.message.toString())
                }
                .collect { monsters ->
                    _monsters.value = UiState.Success(monsters)
                }
        }
    }
}