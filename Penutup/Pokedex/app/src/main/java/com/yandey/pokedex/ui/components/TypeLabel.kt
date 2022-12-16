package com.yandey.pokedex.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.pokedex.R
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun TypeLabel(
    modifier: Modifier = Modifier,
    types: List<String>,
) {
    for (type in types) {
        when (type) {
            "Electric" -> R.color.yellow
            "Water" -> R.color.blue
            "Bug" -> R.color.dark_spring_green
            "Flying" -> R.color.reddish_orange
            "Ghost" -> R.color.blue_cyan
            "Dark" -> R.color.purple_magenta
            "Poison" -> R.color.pinkish_purple
            "Fire" -> R.color.red
            "Psychic" -> R.color.pinkish_red
            "Rock" -> R.color.yellowish_orange
            "Ground" -> R.color.orangy_red
            "Grass" -> R.color.green_cyan
            else -> R.color.black
        }.also { color ->
            ChipView(
                item = type,
                colorResource = colorResource(id = color)
            )
            Spacer(modifier = modifier.width(8.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TypeLabelPreview() {
    PokedexTheme {
        Row {
            TypeLabel(
                types = listOf(
                    "Bug",
                    "Flying"
                )
            )
        }
    }
}