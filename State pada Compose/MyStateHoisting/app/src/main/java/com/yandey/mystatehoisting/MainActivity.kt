package com.yandey.mystatehoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yandey.mystatehoisting.ui.theme.MyStateHoistingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyStateHoistingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CounterPreview()
                }
            }
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(
        count = count,
        onClick = { count++ },
        modifier = modifier,
    )
}

@Composable
fun StatelessCounter(
    count: Int,           //state
    onClick: () -> Unit,  //event
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Text("Button clicked $count times:")
        Button(onClick = { onClick() }) {
            Text("Click me!")
        }
    }
}

@Composable
fun MyScreen(modifier: Modifier = Modifier) {
    // State terletak di MyScreen dan MySwitch
    var checked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(16.dp)
    ) {
        MySwitch(checked = checked, onCheckChanged = { checked = it })
        Text(
            text = if (checked) "ON" else "OFF",
            Modifier.clickable {
                checked = !checked
            }
        )
    }
}

@Composable
fun MySwitch(
    checked: Boolean,
    onCheckChanged: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = {
            onCheckChanged(it)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun StatePreview() {
    MyStateHoistingTheme {
        MyScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    MyStateHoistingTheme {
        StatefulCounter()
    }
}