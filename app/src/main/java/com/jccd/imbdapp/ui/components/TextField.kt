package com.jccd.imbdapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.time.format.TextStyle

@Composable
fun InputTextField(
    labelText: String,
    modifier: Modifier = Modifier,
    spacer: Dp,
) {
    var value by remember { mutableStateOf(TextFieldValue("")) }
    val dividerState = remember {
        mutableStateOf(true)
    }
    BasicTextField(
        value = value,
        onValueChange = { value = it },
        modifier = modifier
            .onFocusChanged {
                dividerState.value = !it.isFocused
            },
        decorationBox = { innerTextField ->
            var mainModifier: Modifier = modifier
            if (!dividerState.value) {
                mainModifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            }

            Column(
                modifier = mainModifier,
                content = {
                    Text(text = labelText)
                    Spacer(modifier = Modifier.size(spacer))
                    innerTextField()
                }
            )
        }
    )
}