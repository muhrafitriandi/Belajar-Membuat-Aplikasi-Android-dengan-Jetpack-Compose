package com.yandey.pokedex.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yandey.pokedex.R
import com.yandey.pokedex.data.FakeMonsterDataSource
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun MonsterBasicInfo(
    modifier: Modifier = Modifier,
    monster: Monster
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp)
    ) {

        Column {

            Box {
                MonsterImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .size(250.dp),
                    monster = monster
                )
            }

            Row {
                MonsterName(
                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                    monster = monster,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.surface
                )

                Spacer(modifier.weight(1f))

                GenderLabel(gender = monster.gender)
            }

            MonsterCategory(
                modifier = modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                monster = monster,
                color = MaterialTheme.colors.surface,
                style = MaterialTheme.typography.caption
            )

            Row(verticalAlignment = Alignment.Bottom) {
                TypeLabel(
                    types = monster.type,
                    modifier = modifier.padding(0.dp, 18.dp, 0.dp, 18.dp)
                )
            }
        }
    }
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
fun MonsterBiologyInfo(
    modifier: Modifier = Modifier,
    monster: Monster
) {
    Spacer(modifier = modifier.height(16.dp))
    Title(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        title = stringResource(id = R.string.text_biology),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = modifier.height(8.dp))
    Value(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp),
        value = monster.biology,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun MonsterAbout(
    modifier: Modifier = Modifier,
    monster: Monster
) {
    Spacer(modifier = modifier.height(16.dp))
    Title(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        title = stringResource(id = R.string.text_about),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = modifier.height(8.dp))
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AboutCard(
            title = stringResource(id = R.string.text_height),
            value = monster.height
        )
        AboutCard(
            title = stringResource(id = R.string.text_weakness),
            value = monster.weakness
        )
        AboutCard(
            title = stringResource(id = R.string.text_weight),
            value = monster.weight
        )
    }
}

@Composable
@Preview
fun MonsterAboutPreview() {
    PokedexTheme {
        Column {
            MonsterAbout(
                monster = FakeMonsterDataSource.dummyMonster[2]
            )
        }
    }
}

@Composable
@Preview
fun MonsterBiologyInfoPreview() {
    PokedexTheme {
        Column {
            MonsterBiologyInfo(
                monster = FakeMonsterDataSource.dummyMonster[2]
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MonsterBasicInfoPreview() {
    PokedexTheme {
        Column {
            MonsterBasicInfo(
                monster = FakeMonsterDataSource.dummyMonster[2]
            )
        }
    }
}