package com.jefisu.financecompose.data

import com.jefisu.financecompose.presentation.components.FlagCard

data class Card(
    val name: String,
    val flag: FlagCard,
    val value: Float,
    val expirationDate: String,
    val number: Long
)