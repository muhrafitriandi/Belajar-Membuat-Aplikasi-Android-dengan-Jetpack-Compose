package com.yandey.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun AboutCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
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
            modifier = modifier.wrapContentWidth()
        ) {

            Text(
                modifier = modifier.fillMaxWidth(),
                color = MaterialTheme.colors.surface,
                text = value,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = modifier.height(8.dp))

            Text(
                modifier = modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.overline,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun AboutCardPreview() {
    PokedexTheme {
        AboutCard(
            title = "Weakness",
            value = "Fire"
        )
    }
}