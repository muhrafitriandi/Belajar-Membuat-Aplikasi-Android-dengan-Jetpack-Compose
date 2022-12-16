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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.pokedex.ui.theme.PokedexTheme
import com.yandey.pokedex.R
import com.yandey.pokedex.data.models.Owner

@Composable
fun OwnerCard(
    modifier: Modifier = Modifier,
    owner: Owner,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        LoadImage(
            modifier = modifier
                .size(70.dp, 70.dp)
                .clip(RoundedCornerShape(70.dp))
                .background(color = colorResource(id = R.color.teal_700))
                .padding(8.dp, 8.dp, 8.dp, 0.dp),
            imageUrl = owner.imageUrl,
            contentDescription = stringResource(id = R.string.content_image, owner.name),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter
        )

        Spacer(modifier = modifier.width(16.dp))

        Column(
            modifier = modifier
                .align(Alignment.CenterVertically)
        ) {

            Text(
                text = owner.name,
                color = MaterialTheme.colors.surface,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = modifier.height(8.dp))

            Text(
                text = owner.trainerClass,
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
            owner = Owner(
                3,
                "May",
                "Pokemon Coordinator",
                "https://archives.bulbagarden.net/media/upload/a/a0/Omega_Ruby_Alpha_Sapphire_May.png"
            )
        )
    }
}