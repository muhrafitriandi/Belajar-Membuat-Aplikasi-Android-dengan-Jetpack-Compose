package com.yandey.mystateholder

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

//data class ExampleUiState(
//    val dataToDisplayOnScreen: List<Example> = emptyList(),
//    val errorMessages: String = "",
//    val loading: Boolean = false
//)

//class ExampleViewModel(
//    private val repository: MyRepository,
//    private val savedState: SavedStateHandle
//) : ViewModel() {
//
//    var uiState by mutableStateOf(ExampleUiState())
//        private set
//
//    val data: Flow<List<Data>> = repository.data
//
//    // Business logic
//    fun somethingRelatedToBusinessLogic() { /* ... */ }
//}

//@Composable
//fun ExampleScreen(viewModel: ExampleViewModel = viewModel()) {
//
//    val uiState = viewModel.uiState
//    val data = viewModel.data.collectAsState
//    /* ... */
//
//    ExampleReusableComponent(
//        someData = uiState.dataToDisplayOnScreen,
//        onDoSomething = { viewModel.somethingRelatedToBusinessLogic() }
//    )
//}

@Composable
fun ExampleReusableComponent(someData: Any, onDoSomething: () -> Unit) {
    /* ... */
    Button(onClick = onDoSomething) {
        Text("Do something")
    }
}