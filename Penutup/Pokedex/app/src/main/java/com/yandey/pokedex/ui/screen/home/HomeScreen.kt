package com.yandey.pokedex.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.common.UiState
import com.yandey.pokedex.R
import com.yandey.pokedex.ui.components.*

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (id: Long) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val query by viewModel.query
    viewModel.monsters.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                LoadingState()
            }
            is UiState.Error -> {
                ErrorState(error = uiState.errorMessage)
            }
            is UiState.Success -> {
                HomeContent(
                    modifier = modifier,
                    monsters = uiState.data,
                    onItemClick = navigateToDetail,
                    query = query,
                    onQueryChange = viewModel::searchMonstersFromDB
                )
            }
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    monsters: List<Monster>,
    onItemClick: (id: Long) -> Unit,
    query: String,
    onQueryChange: (String) -> Unit,
) {
    Column {
        SearchBar(query = query, onQueryChange = onQueryChange)
        if (monsters.isNotEmpty()) {
            ShowMonsters(
                modifier = modifier,
                monsters = monsters,
                onItemClick = onItemClick
            )
        } else {
            EmptyData(text = stringResource(id = R.string.text_pokemon_not_found))
        }
    }
}