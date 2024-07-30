package com.devscion.typistcmp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random


@Composable
internal fun TypistImpl(
    textList: List<String>,
    typingDelay: Long = 100L,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    cursorColor: Color = Color.Black,
    typistSpeed: TypistSpeed = TypistSpeed.NORMAL,
    isInfiniteCursor: Boolean = true,
    isBlinkingCursor: Boolean = true,
    isCursorVisible: Boolean = true,
    isInfinite: Boolean = false,
    cursorSymbol: String = "|",
    onAnimationEnd: (() -> Unit)? = null,
    onAnimationStart: (() -> Unit)? = null,
) {

    val currentTextIndex = remember {
        mutableIntStateOf(0)
    }
    val currentText = remember {
        mutableStateOf("")
    }

    val textChanges = remember {
        mutableLongStateOf(1L)
    }

    val remainingText = remember {
        mutableStateOf(textList[currentTextIndex.intValue])
    }

    LaunchedEffect(textList) {
        resetTextHandlers(currentText, remainingText, textList[currentTextIndex.intValue])
        textChanges.longValue = Random.nextLong()
    }

    LaunchedEffect(key1 = textChanges.longValue) {
        onAnimationStart?.invoke()
        while (remainingText.value.isNotEmpty()) {
            currentText.value += remainingText.value.first()
            remainingText.value = remainingText.value
                .removePrefix("${remainingText.value.first()}")
            delay(typistSpeed.value)
        }
        delay(typingDelay)
        if (remainingText.value.isEmpty()) {
            onAnimationEnd?.invoke()
        }
        if (textList.size > 1 && currentTextIndex.intValue != textList.size - 1) {
            currentTextIndex.intValue++
            resetTextHandlers(
                currentText, remainingText,
                textList[currentTextIndex.intValue]
            )
            if (isInfinite.not())
                textChanges.longValue = Random.nextLong()
        } else if (isInfinite && textList.size > 1 && currentTextIndex.intValue == textList.size - 1) {
            currentTextIndex.intValue = 0
            resetTextHandlers(
                currentText, remainingText,
                textList[currentTextIndex.intValue]
            )
        }
        if (isInfinite) {
            if (textList.size == 1) {
                resetTextHandlers(
                    currentText, remainingText,
                    textList[currentTextIndex.intValue]
                )
            }
            textChanges.longValue = Random.nextLong()
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

fun resetTextHandlers(
    currentText: MutableState<String>,
    remainingText: MutableState<String>,
    text: String
) {
    remainingText.value = text
    currentText.value = ""
}


enum class TypistSpeed(val value: Long) {
    NORMAL(200L), SLOW(500L), EXTRA_SLOW(800L),
    FAST(100L), EXTRA_FAST(10L)
}