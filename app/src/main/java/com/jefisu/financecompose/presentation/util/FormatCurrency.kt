package com.jefisu.financecompose.presentation.util

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat

fun formatCurrency(value: Float, fontSize: TextUnit): AnnotatedString {
    return buildAnnotatedString {
        val valueFormatted = DecimalFormat("$#,##0.00").format(value)
        withStyle(style = SpanStyle(fontSize = fontSize)) {
            append(
                valueFormatted.take(valueFormatted.length - 2)
            )
        }
        withStyle(style = SpanStyle(fontSize = (fontSize.value - 4).sp)) {
            append(
                valueFormatted.takeLast(2)
            )
        }
    }
}