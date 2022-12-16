@file:Suppress("unused")

package com.yandey.pokedex.ui.screen.detail

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yandey.pokedex.R
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.data.models.Owner
import com.yandey.pokedex.ui.common.UiState
import com.yandey.pokedex.ui.components.*

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    id: Long,
    viewModel: DetailViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
) {
    viewModel.monster.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                LoadingState()
                viewModel.getFavoriteStateMonsterFromDB(id)
            }
            is UiState.Error -> {
                ErrorState(error = uiState.errorMessage)
            }
            is UiState.Success -> {
                Details(
                    modifier = modifier,
                    monster = uiState.data,
                    onBackClick = navigateBack,
                    onUpdateFavoriteMonster = viewModel::updateFavoriteMonsterFromDB
                )
            }
        }
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    imageUrl: String,
    name: String,
    gender: String,
    category: String,
    types: List<String>,
    biology: String,
    height: String,
    weakness: String,
    weight: String,
    owner: Owner,
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp, 0.dp, 8.dp, 0.dp),
        modifier = modifier
    ) {
        item {
            MonsterBasicInfo(
                imageUrl = imageUrl,
                name = name,
                gender = gender,
                category = category,
                types = types
            )
        }
        item {
            MonsterBiologyInfo(
                biology = biology
            )
        }
        item {
            MonsterAbout(
                height = height,
                weakness = weakness,
                weight = weight
            )
        }
        item {
            OwnerInfo(owner = owner)
        }
        item {
            FindMeButton()
        }
    }
}

@Composable
fun Details(
    modifier: Modifier = Modifier,
    monster: Monster,
    onBackClick: () -> Unit,
    onUpdateFavoriteMonster: (id: Long, isFavorite: Boolean) -> Unit,
) {

    val (id, name, category, types, gender, biology, height, weakness, weight, imageUrl, owner, isFavorite) = monster

    var enabled by remember {
        mutableStateOf(isFavorite)
    }

    val context = LocalContext.current.applicationContext
    val message = "$name ${
        if (!enabled) stringResource(id = R.string.toast_item_added_to_favorite)
        else stringResource(id = R.string.toast_item_removed_from_favorite)
    }"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.text_details)) },
                actions = {
                    IconButton(onClick = {
                        onUpdateFavoriteMonster(id, !isFavorite)
                        enabled = !isFavorite
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = if (enabled) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = stringResource(id = R.string.button_favorite),
                            tint = if (enabled) Color.Red else MaterialTheme.colors.surface
                        )
                    }
                },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.background,
                modifier = modifier.padding(start = 16.dp),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.button_back),
                        modifier = modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                onBackClick()
                            }
                    )
                }
            )
        },

        content = {
            DetailContent(
                imageUrl = imageUrl,
                name = name,
                gender = gender,
                category = category,
                types = types,
                biology = biology,
                height = height,
                weakness = weakness,
                weight = weight,
                modifier = modifier.padding(it),
                owner = owner
            )
        }
    )
}