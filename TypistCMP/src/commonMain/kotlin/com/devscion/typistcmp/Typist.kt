package com.devscion.typistcmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


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
    isInfinite: Boolean = false,
    cursorSymbol: String = "|",
    onAnimationEnd: (() -> Unit)? = null,
    onAnimationStart: (() -> Unit)? = null,
) {
    TypistImpl(
        listOf(text),
        modifier,
        textStyle,
        cursorColor,
        typistSpeed,
        isInfiniteCursor,
        isBlinkingCursor,
        isCursorVisible,
        isInfinite,
        cursorSymbol,
        onAnimationEnd,
        onAnimationStart,
    )
}

@Throws(IndexOutOfBoundsException::class)
@Composable
fun Typist(
    textList: List<String>,
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
    if (textList.isEmpty()){
        throw IndexOutOfBoundsException()
    }
    TypistImpl(
        textList,
        modifier,
        textStyle,
        cursorColor,
        typistSpeed,
        isInfiniteCursor,
        isBlinkingCursor,
        isCursorVisible,
        isInfinite,
        cursorSymbol,
        onAnimationEnd,
        onAnimationStart,
    )
}