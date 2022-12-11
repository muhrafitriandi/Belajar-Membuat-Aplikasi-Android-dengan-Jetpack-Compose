package com.yandey.pokedex.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.common.UiState
import com.yandey.pokedex.ui.components.MonsterItem
import com.yandey.pokedex.ui.components.SearchBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (id: Long) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val query by viewModel.query
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.search(query)
            }
            is UiState.Success -> {
                HomeContent(
                    modifier = modifier,
                    monsters = uiState.data,
                    onItemClick = navigateToDetail,
                    query = query,
                    onQueryChange = viewModel::search
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    monsters: List<Monster>,
    onItemClick: (id: Long) -> Unit,
    query: String,
    onQueryChange: (String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
    ) {
        item {
            SearchBar(query = query, onQueryChange = onQueryChange)
        }
        items(monsters) { monster ->
            MonsterItem(monster = monster) { id ->
                onItemClick(id)
            }
        }
    }
}