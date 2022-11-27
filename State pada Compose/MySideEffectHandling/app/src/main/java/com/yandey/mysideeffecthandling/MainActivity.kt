package com.yandey.mysideeffecthandling

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.yandey.mysideeffecthandling.ui.theme.MySideEffectHandlingTheme
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySideEffectHandlingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        CounterPreview()
                        MyCountdownPreview()
                        MyAppPreview()
                        MyRememberedCoroutineScopePreview()
                        // MyCountdownSideEffectPreview()
                        // MyCountdownDisposableEffectPreview()
                        MySnapshotFlowPreview()
                        MyComposablePreview()
                    }
                }
            }
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        if (count > 0) {
            Text("Button clicked $count times:")
        }
        Button(onClick = { count++ }) {
            Text("Click me!")
        }
        Button(onClick = { count = 0 }) {
            Text("Reset")
        }
    }
}

var i = 0

@Composable
fun MyComposable() {
    i++ // mengubah nilai di sini akan menyebabkan side effect
    Log.d("Check", "$i")
    Button(onClick = {}) {
        Text(text = "Click")
    }
}

@Composable
fun MyCountdown() {
    var timer by remember { mutableStateOf(60) }
    Text("Countdown : $timer")
    LaunchedEffect(true) {
        while (timer > 0) {
            delay(1000)
            timer--
        }
    }
}

@Composable
fun MyCountdownTimeout(onTimeout: () -> Unit) {
    var timer by remember { mutableStateOf(10) }
    val currentOnTimeout by rememberUpdatedState(onTimeout)
    Text("Countdown : $timer")
    LaunchedEffect(true) {
        while (timer > 0) {
            delay(1000)
            timer--
        }
        currentOnTimeout()
    }
}

@Composable
fun MyApp() {
    var showTimeOutScreen by remember { mutableStateOf(false) }
    if (showTimeOutScreen) {
        // TimeOutScreen()
        Text("TIMEOUT!!!")
    } else {
        MyCountdownTimeout(onTimeout = {
            Log.d("MyApp", "onTimeout called")
            showTimeOutScreen = true
        })
    }
}

@Composable
fun MyRememberedCoroutineScope() {
    var timer by remember { mutableStateOf(60) }
    val scope = rememberCoroutineScope()
    var job: Job? by remember { mutableStateOf(null) }
    Column {
        Text(text = "Countdown : $timer")
        Button(onClick = {
            job?.cancel()
            timer = 60
            job = scope.launch {
                while (timer > 0) {
                    delay(1000)
                    timer--
                }
            }
        }) {
            Text("Start")
        }
    }
}

@Composable
fun MyCountdownSideEffect() {
    var timer by remember { mutableStateOf(60) }
    Text(text = "Countdown : $timer")
    SideEffect {
        while (timer > 0) {
            Thread.sleep(1000)
            timer--
        }
    }
}

@Composable
fun MyCountdownDisposableEffect() {
    var timer by remember { mutableStateOf(60) }
    val scope = rememberCoroutineScope()
    var job: Job? by remember { mutableStateOf(null) }
    val lifecycleOwner = LocalLifecycleOwner.current
    Column {
        Text(text = "Countdown : $timer")
        DisposableEffect(lifecycleOwner) {
            val observer = LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_START) {
                    job?.cancel()
                    timer = 60
                    job = scope.launch {
                        while (timer > 0) {
                            delay(1000)
                            timer--
                        }
                    }
                } else if (event == Lifecycle.Event.ON_STOP) {
                    job?.cancel()
                    timer = 60
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }
    }
}

@Composable
fun MySnapshotFlow() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        LazyColumn(state = listState) {
            items(1000) { index ->
                Text(text = "Item: $index")
            }
        }

        var showButtonSnapshot by remember { mutableStateOf(false) }

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            AnimatedVisibility(showButtonSnapshot) {
                Button(onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(0)
                    }
                }) {
                    Text("Jump to Top")
                }
            }
        }

        LaunchedEffect(listState) {
            snapshotFlow { listState.firstVisibleItemIndex }
                .map { index -> index > 2 }
                .distinctUntilChanged()
                .collect {
                    showButtonSnapshot = it
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MySnapshotFlowPreview() {
    MySideEffectHandlingTheme {
        MySnapshotFlow()
    }
}

@Preview(showBackground = true)
@Composable
fun MyCountdownDisposableEffectPreview() {
    MySideEffectHandlingTheme {
        MyCountdownDisposableEffect()
    }
}

@Preview(showBackground = true)
@Composable
fun MyCountdownSideEffectPreview() {
    MySideEffectHandlingTheme {
        MyCountdownSideEffect()
    }
}

@Preview(showBackground = true)
@Composable
fun MyRememberedCoroutineScopePreview() {
    MySideEffectHandlingTheme {
        MyRememberedCoroutineScope()
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MySideEffectHandlingTheme {
        MyApp()
    }
}

@Preview(showBackground = true)
@Composable
fun MyCountdownPreview() {
    MySideEffectHandlingTheme {
        MyCountdown()
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    MySideEffectHandlingTheme {
        Counter()
    }
}

@Preview(showBackground = true)
@Composable
fun MyComposablePreview() {
    MySideEffectHandlingTheme {
        MyComposable()
    }
}

//@Composable
//fun ImageScreen(
//    modifier: Modifier = Modifier,
//    viewModel: MyViewModel = viewModel()
//) {
//
//    val uiState by produceState(initialValue = ImageUiState(isLoading = true)) {
//        val image = viewModel.image
//        value = if (image != null) {
//            ImageUiState(imageData = image)
//        } else {
//            ImageUiState(isError = true)
//        }
//    }
//}

//val jumpToBottomButtonEnabled by remember {
//    derivedStateOf {
//        scrollState.firstVisibleItemIndex != 0 ||
//                scrollState.firstVisibleItemScrollOffset > jumpThreshold
//    }
//}

//data class ImageUiState(
//    val imageData: String? = null,
//    val isLoading: Boolean = false,
//    val isError: Boolean = false
//)