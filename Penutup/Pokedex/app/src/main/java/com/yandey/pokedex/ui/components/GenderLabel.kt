package com.yandey.pokedex.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yandey.pokedex.R
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun GenderLabel(
    modifier: Modifier = Modifier,
    gender: String,
) {
    val color =
        if (gender == stringResource(id = R.string.gender_male)) R.color.blue
        else R.color.red
    Box(modifier = modifier) {
        ChipView(
            item = gender,
            colorResource = colorResource(id = color)
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