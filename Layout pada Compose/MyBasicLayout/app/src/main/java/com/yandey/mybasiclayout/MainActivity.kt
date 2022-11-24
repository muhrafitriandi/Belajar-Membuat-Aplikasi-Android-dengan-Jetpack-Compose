package com.yandey.mybasiclayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
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
import com.yandey.mybasiclayout.ui.theme.MyBasicLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBasicLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContactCard()
                }
            }
        }
    }
}

@Composable
fun ContactCard() {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.avatar1),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Online Status",
                tint = Color.Green,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "Dico Wisesa",
                fontWeight = FontWeight.Bold,
            )
            Text("Online")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBasicLayoutTheme {
        ContactCard()
    }
}

@Composable
fun ButtonA() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_200)),
        modifier = Modifier.size(80.dp)
    ) {
        Text("A")
    }
}

@Composable
fun ButtonB() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_500)),
        modifier = Modifier.size(60.dp)
    ) {
        Text("B")
    }
}

@Composable
fun ButtonC(text: String = "C") {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_700)),
        modifier = Modifier.size(40.dp)
    ) {
        Text(text)
    }
}

@Composable
fun RowButton() {
    Row(modifier = Modifier.padding(16.dp)) {
        ButtonC("")
        Spacing()
        ButtonC("")
        Spacing()
        ButtonC("")
    }
}

@Composable
fun Spacing() {
    Spacer(modifier = Modifier.padding(8.dp))
}

@Composable
fun ColumnButton() {
    Column(modifier = Modifier.padding(16.dp)) {
        ButtonC("")
        Spacing()
        ButtonC("")
        Spacing()
        ButtonC("")
    }
}