package com.yandey.mystateholder

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class FormInputState(initialInput: String) {
    var input by mutableStateOf(initialInput)
}

@Composable
fun rememberFormInputState(input: String): FormInputState =
    remember(input) {
        FormInputState(input)
    }

@Composable
fun MyForm() {
    val input = rememberFormInputState("")
    FormInput(
        state = input
    )
}

@Composable
fun FormInput(
    state: FormInputState = rememberFormInputState("")
) {
    OutlinedTextField(
        value = state.input,
        onValueChange = { state.input = it },
        label = { Text("Nama") },
        modifier = Modifier.padding(8.dp)
    )
}