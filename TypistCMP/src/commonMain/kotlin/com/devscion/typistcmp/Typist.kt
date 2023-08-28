package com.devscion.typistcmp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Typist(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    cursorColor: Color = Color.Black,
    typistSpeed: TypistSpeed = TypistSpeed.NORMAL,
    isInfiniteCursor: Boolean = true,
    isBlinkingCursor: Boolean = true,
    isCursorVisible: Boolean = true,
    cursorSymbol: String = "|",
    onAnimationEnd: (() -> Unit)? = null,
    onAnimationStart: (() -> Unit)? = null,
) {
    val currentText = remember {
        mutableStateOf("")
    }

    val textChanges = remember {
        mutableStateOf(1)
    }

    val remainingText = remember {
        mutableStateOf(text)
    }

    LaunchedEffect(text){
        currentText.value = ""
        remainingText.value = text
        textChanges.value++
    }
    LaunchedEffect(key1 = textChanges.value) {
        onAnimationStart?.invoke()
        while (remainingText.value.isNotEmpty()) {
            currentText.value += remainingText.value.first()
            remainingText.value = remainingText.value.removePrefix("${remainingText.value.first()}")
            delay(typistSpeed.value)
        }
        if (remainingText.value.isEmpty()) {
            onAnimationEnd?.invoke()
        }
    }

    Row(
        modifier = modifier
            .animateContentSize()
            .padding(end = 5.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = currentText.value,
            style = textStyle,
        )
        Spacer(modifier = Modifier.width(2.dp))
        if (isCursorVisible) {
            val isCursorActive = remainingText.value.isNotEmpty() || isInfiniteCursor
            if (isBlinkingCursor && isCursorActive)
                BlinkingCursor(
                    style = textStyle.copy(color = cursorColor),
                    cursorSymbol = cursorSymbol
                )
            else if (isCursorActive)
                Text(
                    text = cursorSymbol,
                    style = textStyle.copy(color = cursorColor),
                )
        }
    }
}


enum class TypistSpeed(val value: Long) {
    NORMAL(200L), SLOW(500L), EXTRA_SLOW(800L), FAST(100L), EXTRA_FAST(10L)
}