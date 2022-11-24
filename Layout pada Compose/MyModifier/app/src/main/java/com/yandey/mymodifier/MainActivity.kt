package com.yandey.mymodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.mymodifier.ui.theme.MyModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyModifierTheme {
        ContactCard(name = "Dico Wisesa")
    }
}

@Composable
fun ContactCard(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = {})
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(R.drawable.avatar1),
            contentDescription = "Avatar",
            modifier = Modifier
                .padding(4.dp)
                .border(2.dp, Color.Green, CircleShape)
                .clip(CircleShape)
                .size(60.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column (modifier = Modifier.weight(1f)){
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
            )
            Text(text = "Online")
        }
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = null,
            modifier = Modifier.offset(x=8.dp, y = 30.dp)
        )
    }
}

@Composable
fun ButtonWithText(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_500)),
        modifier = modifier.padding(4.dp)
    ) {
        Text(text, textAlign = TextAlign.Center)
    }
}

@Composable
fun Weight() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),) {
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("1", Modifier.weight(1f))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("2", Modifier.weight(2f))
            ButtonWithText("1", Modifier.weight(1f))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("2", Modifier.weight(2f))
            ButtonWithText("3", Modifier.weight(3f))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("2", Modifier.weight(2f))
            ButtonWithText("3 fill true", Modifier.weight(3f, true))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f, true))
            ButtonWithText("2", Modifier.weight(2f, true))
            ButtonWithText("3 fill false", Modifier.weight(3f, false))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("0")
            ButtonWithText("0")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ParameterModifierPreview() {
    MyModifierTheme {
        Weight()
    }
}

