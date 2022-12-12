package com.yandey.pokedex.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun OwnerInfo(
    modifier: Modifier = Modifier,
    monster: Monster
) {
    Spacer(modifier = modifier.height(16.dp))
    Title(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        title = stringResource(id = R.string.text_owner),
        style = MaterialTheme.typography.subtitle1,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = modifier.height(8.dp))
    OwnerCard(
        monster = monster
    )
}

@Composable
fun FindMeButton(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = Modifier.height(16.dp))
    Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            text = stringResource(id = R.string.text_find_me),
            color = MaterialTheme.colors.onSurface
        )
    }
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
@Preview
fun FindMeButtonPreview() {
    PokedexTheme {
        Column {
            FindMeButton()
        }
    }
}

@Composable
@Preview
fun OwnerInfoPreview() {
    PokedexTheme {
        Column {
            OwnerInfo(monster = FakeMonsterDataSource.dummyMonster[2])
        }
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