package com.yandey.pokedex.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarActionButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            imageVector = imageVector,
            contentDescription = description
        )
    }
}