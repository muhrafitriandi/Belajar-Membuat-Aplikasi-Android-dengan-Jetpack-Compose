package com.yandey.pokedex.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yandey.pokedex.R
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.data.models.Owner
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun MonsterInfo(
    modifier: Modifier = Modifier,
    monster: Monster,
    onBackClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Box {
                AsyncImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .size(250.dp),
                    model = monster.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.text_back),
                    modifier = modifier
                        .clickable {
                            onBackClick()
                        }
                )
            }
            Row {
                Text(
                    text = monster.name,
                    modifier = modifier
                        .padding(0.dp, 0.dp, 0.dp, 8.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5
                )

                Spacer(modifier.weight(1f))

                GenderLabel(gender = monster.gender)
            }

            Row(verticalAlignment = Alignment.Bottom) {
                TypeLabel(
                    types = monster.type,
                    modifier = modifier.padding(0.dp, 16.dp, 0.dp, 16.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MonsterInfoPreview() {
    PokedexTheme {
        Row {
            MonsterInfo(
                monster = Monster(
                    3,
                    "Butterfree",
                    "Butterfly",
                    listOf("Bug", "Flying"),
                    "Female",
                    "Butterfree is a lepidopteran insect Pokémon which resembles a vaguely anthropomorphic butterfly with a purple body. Unlike true insects, it only has two body segments and four light blue legs. The upper pair of its legs resemble small, three-fingered hands, while the lower pair resembles long, digit-less feet. Butterfree has two black antennae, a light blue snout with two fangs underneath, and large, red compound eyes. Its two pairs of wings are white with black venation. Two oval scales on a female Butterfree's lower wings are black, but they are white on a male.",
                    "3' 07\"",
                    "Fire",
                    "70.5 lbs",
                    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/012.png",
                    Owner(
                        3,
                        "May",
                        "Pokemon Coordinator",
                        "https://archives.bulbagarden.net/media/upload/a/a0/Omega_Ruby_Alpha_Sapphire_May.png"
                    )
                ),
                onBackClick = {}
            )
        }
    }
}