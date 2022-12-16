package com.yandey.pokedex.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.pokedex.R
import com.yandey.pokedex.data.FakeMonsterDataSource
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun MonsterItem(
    modifier: Modifier = Modifier,
    monster: Monster,
    onItemClick: (id: Long) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = {
                onItemClick(monster.id)
            }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            LoadImage(
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                imageUrl = monster.imageUrl,
                contentDescription = stringResource(id = R.string.content_image, monster.name),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = modifier.width(16.dp))

            Column {

                Text(
                    text = monster.name,
                    style = typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.surface
                )

                Spacer(modifier = modifier.height(8.dp))

                Text(
                    text = monster.category,
                    color = MaterialTheme.colors.surface,
                    style = typography.caption
                )

                Row(verticalAlignment = Alignment.Bottom) {
                    TypeLabel(
                        types = monster.type,
                        modifier = modifier.padding(0.dp, 19.dp, 0.dp, 18.dp)
                    )
                }
            }
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                GenderLabel(gender = monster.gender)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MonsterItemPreview() {
    PokedexTheme {
        Row {
            MonsterItem(
                monster = FakeMonsterDataSource.dummyMonster[2],
                onItemClick = {}
            )
        }
    }
}