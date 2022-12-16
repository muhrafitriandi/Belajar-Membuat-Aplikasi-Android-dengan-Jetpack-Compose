package com.yandey.pokedex.ui.screen.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.yandey.pokedex.R
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.common.UiState
import com.yandey.pokedex.ui.components.EmptyData
import com.yandey.pokedex.ui.components.ErrorState
import com.yandey.pokedex.ui.components.LoadingState
import com.yandey.pokedex.ui.components.ShowMonsters

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel(),
    navigateToDetail: (id: Long) -> Unit,
) {
    viewModel.monsters.collectAsState(UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                LoadingState()
            }
            is UiState.Error -> {
                ErrorState(error = uiState.errorMessage)
            }
            is UiState.Success -> {
                FavoriteContent(
                    modifier = modifier,
                    monsters = uiState.data,
                    onItemClick = navigateToDetail
                )
            }
        }
    }
}

@Composable
fun FavoriteContent(
    modifier: Modifier = Modifier,
    monsters: List<Monster>,
    onItemClick: (id: Long) -> Unit,
) {
    if (monsters.isNotEmpty()) {
        ShowMonsters(
            modifier = modifier,
            monsters = monsters,
            onItemClick = onItemClick
        )
    } else {
        EmptyData(text = stringResource(id = R.string.text_no_favorites))
    }
}