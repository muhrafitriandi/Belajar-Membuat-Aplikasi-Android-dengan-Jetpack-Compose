package com.yandey.pokedex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun EmptyData(
    text: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text
        )
    }
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    title: String,
    style: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    textAlign: TextAlign? = null
) {
    Text(
        text = title,
        modifier = modifier,
        color = color,
        style = style,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}

@Composable
fun Value(
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontWeight: FontWeight? = null,
    value: String,
    style: TextStyle = LocalTextStyle.current,
    textAlign: TextAlign? = null
) {
    Text(
        text = value,
        modifier = modifier,
        color = color,
        fontWeight = fontWeight,
        style = style,
        textAlign = textAlign
    )
}

@Composable
fun MonsterImage(
    modifier: Modifier = Modifier,
    monster: Monster,
    contentScale: ContentScale = ContentScale.Fit
) {
    AsyncImage(
        modifier = modifier,
        model = monster.imageUrl,
        contentDescription = null,
        contentScale = contentScale
    )
}

@Composable
fun MonsterName(
    modifier: Modifier = Modifier,
    monster: Monster,
    style: TextStyle = LocalTextStyle.current,
    fontWeight: FontWeight? = null,
    color: Color = Color.Unspecified
) {
    Text(
        modifier = modifier,
        text = monster.name,
        style = style,
        fontWeight = fontWeight,
        color = color
    )
}

@Composable
fun MonsterCategory(
    modifier: Modifier = Modifier,
    monster: Monster,
    color: Color = Color.Unspecified,
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        modifier = modifier,
        text = monster.category,
        color = color,
        style = style
    )
}

@Composable
@Preview
fun EmptyDataPreview() {
    PokedexTheme {
        EmptyData(
            text = "Pokemon not found"
        )
    }
}