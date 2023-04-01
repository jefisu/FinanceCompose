package com.jefisu.financecompose.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DottedCircle(
    modifier: Modifier = Modifier,
    sizeCircle: Dp = 60.dp,
    color: Color = Color.White.copy(0.2f)
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Canvas(modifier = Modifier.size(sizeCircle)) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawCircle(
                color = color,
                radius = size.minDimension / 2,
                center = Offset(
                    x = canvasWidth / 2,
                    y = canvasHeight / 2
                ),
                style = Stroke(
                    width = 8f,
                    pathEffect = PathEffect.dashPathEffect(
                        intervals = floatArrayOf(10f, 4f),
                        phase = 0f
                    )
                )
            )
        }
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size((sizeCircle.value - 18).dp)
        )
    }
}

@Preview
@Composable
fun PreviewDottedCircle() {
    DottedCircle()
}