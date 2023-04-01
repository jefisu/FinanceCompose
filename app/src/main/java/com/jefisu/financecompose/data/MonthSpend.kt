package com.jefisu.financecompose.data

import androidx.compose.ui.graphics.Color
import java.time.Month

data class MonthSpend(
    val month: Month,
    val percent: Float,
    val color: Color
)
