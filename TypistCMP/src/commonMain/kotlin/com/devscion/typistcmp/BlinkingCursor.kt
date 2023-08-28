package com.devscion.typistcmp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay

@Composable
internal fun BlinkingCursor(
    style: TextStyle,
    cursorSymbol: String
) {

    val isVisible = remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = true) {
        while (true) {
            isVisible.value = isVisible.value.not()
            delay(TypistSpeed.NORMAL.value * 2L)
        }
    }

    Text(if (isVisible.value) cursorSymbol else " ", style = style)
}