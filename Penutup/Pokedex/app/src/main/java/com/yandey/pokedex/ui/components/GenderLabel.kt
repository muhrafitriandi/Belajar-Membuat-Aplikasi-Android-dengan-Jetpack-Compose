package com.yandey.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.pokedex.R
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun GenderLabel(
    modifier: Modifier = Modifier,
    gender: String
) {
    val color = if (gender == stringResource(id = R.string.gender_male)) R.color.blue else R.color.red
    Box(modifier = modifier) {
        ChipView(
            modifier = modifier,
            item = gender,
            colorResource = colorResource(id = color)
        )
    }
}

@Composable
fun ChipView(
    modifier: Modifier = Modifier,
    item: Any,
    colorResource: Color
) {
    Box(
        modifier = modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
    ) {
        Text(
            text = item as String,
            modifier = modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            style = MaterialTheme.typography.caption,
            color = colorResource
        )
    }
}

@Composable
@Preview(showBackground = true)
fun GenderLabelPreview() {
    PokedexTheme {
        GenderLabel(
            gender = "Male"
        )
    }
}