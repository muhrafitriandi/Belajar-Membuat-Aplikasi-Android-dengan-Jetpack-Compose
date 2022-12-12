package com.yandey.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yandey.pokedex.data.FakeMonsterDataSource
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.theme.PokedexTheme
import com.yandey.pokedex.R

@Composable
fun OwnerCard(
    modifier: Modifier = Modifier,
    monster: Monster
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        AsyncImage(
            modifier = modifier
                .size(70.dp, 70.dp)
                .clip(RoundedCornerShape(70.dp))
                .background(color = colorResource(id = R.color.teal_700))
                .padding(8.dp, 8.dp, 8.dp, 0.dp),
            model = monster.owner.imageUrl,
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = modifier
                .align(Alignment.CenterVertically)
        ) {

            Title(
                title = monster.owner.name,
                color = MaterialTheme.colors.surface,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(8.dp))

            Value(
                value = monster.owner.trainerClass,
                color = MaterialTheme.colors.surface,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
@Preview
fun OwnerCardPreview() {
    PokedexTheme {
        OwnerCard(
            monster = FakeMonsterDataSource.dummyMonster[2]
        )
    }
}