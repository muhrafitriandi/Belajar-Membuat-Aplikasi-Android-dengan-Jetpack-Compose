package com.yandey.pokedex.ui.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yandey.pokedex.R
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.common.UiState
import com.yandey.pokedex.ui.components.*

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
                Details(
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
    monster: Monster
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp, 0.dp, 8.dp, 0.dp),
        modifier = modifier
    ) {
        item {
            MonsterBasicInfo(
                monster = monster
            )
        }
        item {
            MonsterBiologyInfo(
                monster = monster
            )
        }
        item {
            MonsterAbout(
                monster = monster
            )
        }
    }
}

@Composable
fun Details(
    modifier: Modifier = Modifier,
    monster: Monster,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.text_details)) },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background,
                modifier = modifier.padding(start = 16.dp),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                onBackClick()
                            }
                    )
                }
            )
        },

        content = {
            DetailContent(monster = monster, modifier = modifier.padding(it))
        }
    )
}