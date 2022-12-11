package com.yandey.pokedex.ui.screen.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.common.UiState
import com.yandey.pokedex.ui.components.MonsterInfo

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    id: Long,
    viewModel: DetailViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getMonsterById(id)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    modifier = modifier,
                    monster = data,
                    onBackClick = navigateBack
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    monster: Monster,
    onBackClick: () -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
    ) {
        item {
            MonsterInfo(
                monster = monster,
                onBackClick = onBackClick
            )
        }
    }
}