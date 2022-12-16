package com.yandey.pokedex.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.pokedex.R
import com.yandey.pokedex.data.models.Owner
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun MonsterBasicInfo(
    modifier: Modifier = Modifier,
    imageUrl: String,
    name: String,
    gender: String,
    category: String,
    types: List<String>,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp)
    ) {

        Column {

            Box {
                LoadImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .size(250.dp),
                    imageUrl = imageUrl,
                    contentDescription = stringResource(id = R.string.content_image, name)
                )
            }

            Row {
                Text(
                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                    text = name,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.surface
                )

                Spacer(modifier.weight(1f))

                GenderLabel(gender = gender)
            }

            Text(
                modifier = modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                text = category,
                color = MaterialTheme.colors.surface,
                style = MaterialTheme.typography.caption
            )

            Row(verticalAlignment = Alignment.Bottom) {
                TypeLabel(
                    types = types,
                    modifier = modifier.padding(0.dp, 18.dp, 0.dp, 18.dp)
                )
            }
        }
    }
}

@Composable
fun MonsterBiologyInfo(
    modifier: Modifier = Modifier,
    biology: String,
) {
    Spacer(modifier = modifier.height(16.dp))
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        text = stringResource(id = R.string.text_biology),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )

    Spacer(modifier = modifier.height(8.dp))

    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp),
        text = biology,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun MonsterAbout(
    modifier: Modifier = Modifier,
    height: String,
    weakness: String,
    weight: String,
) {
    Spacer(modifier = modifier.height(16.dp))
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        text = stringResource(id = R.string.text_about),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )

    Spacer(modifier = modifier.height(8.dp))

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AboutCard(
            title = stringResource(id = R.string.text_height),
            value = height
        )
        AboutCard(
            title = stringResource(id = R.string.text_weakness),
            value = weakness
        )
        AboutCard(
            title = stringResource(id = R.string.text_weight),
            value = weight
        )
    }
}

@Composable
fun OwnerInfo(
    modifier: Modifier = Modifier,
    owner: Owner,
) {
    Spacer(modifier = modifier.height(16.dp))
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        text = stringResource(id = R.string.text_owner),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = modifier.height(8.dp))
    OwnerCard(owner = owner)
}

@Composable
fun FindMeButton(
    modifier: Modifier = Modifier,
) {
    Spacer(modifier = modifier.height(16.dp))
    Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            text = stringResource(id = R.string.text_find_me),
            color = MaterialTheme.colors.onSurface
        )
    }
    Spacer(modifier = modifier.height(24.dp))
}

@Composable
@Preview
fun FindMeButtonPreview() {
    PokedexTheme {
        Column {
            FindMeButton()
        }
    }
}

@Composable
@Preview
fun OwnerInfoPreview() {
    PokedexTheme {
        Column {
            OwnerInfo(
                owner = Owner(
                    3,
                    "May",
                    "Pokemon Coordinator",
                    "https://archives.bulbagarden.net/media/upload/a/a0/Omega_Ruby_Alpha_Sapphire_May.png"
                )
            )
        }
    }
}

@Composable
@Preview
fun MonsterAboutPreview() {
    PokedexTheme {
        Column {
            MonsterAbout(
                height = "3' 07\"",
                weakness = "Fire",
                weight = "70.5 lbs"
            )
        }
    }
}

@Composable
@Preview
fun MonsterBiologyInfoPreview() {
    PokedexTheme {
        Column {
            MonsterBiologyInfo(
                biology = "Butterfree is a lepidopteran insect Pokémon which resembles a vaguely anthropomorphic butterfly with a purple body. Unlike true insects, it only has two body segments and four light blue legs. The upper pair of its legs resemble small, three-fingered hands, while the lower pair resembles long, digit-less feet. Butterfree has two black antennae, a light blue snout with two fangs underneath, and large, red compound eyes. Its two pairs of wings are white with black venation. Two oval scales on a female Butterfree's lower wings are black, but they are white on a male."
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MonsterBasicInfoPreview() {
    PokedexTheme {
        Column {
            MonsterBasicInfo(
                imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/012.png",
                name = "Butterfree",
                gender = "Female",
                category = "Butterfly",
                types = listOf("Bug", "Flying")
            )
        }
    }
}