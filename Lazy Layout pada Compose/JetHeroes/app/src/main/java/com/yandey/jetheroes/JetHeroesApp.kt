package com.yandey.jetheroes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import com.yandey.jetheroes.ui.theme.JetHeroesTheme

@Composable
fun HeroListItem(
    name: String,
    photoUrl: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {}
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroListItemPreview() {
    JetHeroesTheme {
        HeroListItem(
            name = "H.O.S. Cokroaminoto",
            photoUrl = ""
        )
    }
}

@Composable
fun JetHeroesApp(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(HeroesData.heroes, key = { it.id }) { hero ->
                HeroListItem(
                    name = hero.name,
                    photoUrl = hero.photoUrl,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JetHeroesAppPreview() {
    JetHeroesTheme {
        JetHeroesApp()
    }
}