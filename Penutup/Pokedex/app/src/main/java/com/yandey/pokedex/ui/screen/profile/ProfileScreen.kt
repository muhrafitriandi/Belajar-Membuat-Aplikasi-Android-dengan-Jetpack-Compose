package com.yandey.pokedex.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yandey.pokedex.ui.components.LoadImage
import com.yandey.pokedex.R

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(16.dp))
            LoadImage(
                modifier = modifier
                    .size(250.dp, 250.dp)
                    .clip(RoundedCornerShape(250.dp))
                    .background(color = MaterialTheme.colors.onSurface),
                imageUrl = "https://media-exp1.licdn.com/dms/image/D5603AQFKtLaOs8doPw/profile-displayphoto-shrink_800_800/0/1669266249560?e=1676505600&v=beta&t=vs5Gkg8elP073JHpLsF8q7P8yLWwnPMUAZ5bpM5E2VI",
                contentDescription = stringResource(id = R.string.content_image, "Muhammad Rafi Triandi"),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = modifier.height(24.dp))

            Text(
                text = "Muhammad Rafi Triandi",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.surface
            )

            Spacer(modifier = modifier.height(24.dp))

            Text(
                text = "muhammadrafitriandi@gmail.com",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.surface
            )

            Spacer(modifier = modifier.height(16.dp))
        }
    }
}