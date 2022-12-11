package com.yandey.pokedex.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.data.models.Owner
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun MonsterItem(
    modifier: Modifier = Modifier,
    monster: Monster,
    onItemClick: (id: Long) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = {
                onItemClick(monster.id)
            }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                modifier = modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                model = monster.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = modifier.width(16.dp))

            Column {
                Text(
                    text = monster.name,
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = typography.subtitle1
                )

                Spacer(modifier = modifier.height(8.dp))

                Text(
                    text = monster.category,
                    color = MaterialTheme.colors.surface,
                    style = typography.caption
                )
                Row(verticalAlignment = Alignment.Bottom) {
                    TypeLabel(
                        types = monster.type,
                        modifier = modifier.padding(0.dp, 24.dp, 0.dp, 16.dp)
                    )
                }
            }
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                GenderLabel(gender = monster.gender)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MonsterItemPreview() {
    PokedexTheme {
        Row {
            MonsterItem(
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
                onItemClick = {}
            )
        }
    }
}