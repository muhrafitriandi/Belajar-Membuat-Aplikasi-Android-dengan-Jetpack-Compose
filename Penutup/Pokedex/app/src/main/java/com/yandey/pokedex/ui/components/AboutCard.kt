package com.yandey.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun AboutCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String
) {
    Box(
        modifier = modifier
            .size(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = MaterialTheme.colors.onSurface)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.wrapContentWidth()
        ) {
            Value(
                modifier = modifier
                    .fillMaxWidth(),
                color = MaterialTheme.colors.surface,
                value = value,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Title(
                title = title,
                modifier = modifier.fillMaxWidth(),
                style = MaterialTheme.typography.overline,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview
fun AboutCardPreview() {
    PokedexTheme {
        AboutCard(
            title = "Weakness",
            value = "Fire"
        )
    }
}