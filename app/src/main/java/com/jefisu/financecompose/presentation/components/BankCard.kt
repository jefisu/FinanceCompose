package com.jefisu.financecompose.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jefisu.financecompose.R
import com.jefisu.financecompose.data.Card
import com.jefisu.financecompose.data.FinanceConstants
import com.jefisu.financecompose.presentation.util.formatCurrency
import com.jefisu.financecompose.ui.theme.HighlightedCardColor
import com.jefisu.financecompose.ui.theme.Surface

sealed class FlagCard(@DrawableRes val image: Int) {
    object Visa : FlagCard(R.drawable.visa)
    object MasterCard : FlagCard(R.drawable.master_card)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BankCard(
    card: Card,
    isHighlightedCard: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val disabledColor = Color.White.copy(0.1f)

    Surface(
        color = Color.Transparent,
        onClick = onClick,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .width(190.dp)
                .clip(RoundedCornerShape(28.dp))
                .background(
                    brush = if (isHighlightedCard) HighlightedCardColor else SolidColor(disabledColor)
                )
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(28.dp),
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.2f),
                            Color.White.copy(alpha = 0.2f)
                        )
                    )
                )
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(card.flag.image),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_two_dots),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(16.dp)
                        .rotate(90f)
                )
            }
            Spacer(modifier = Modifier.height(42.dp))
            Text(
                text = card.name,
                style = MaterialTheme.typography.subtitle1,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = formatCurrency(card.value, 28.sp),
                color = Color.White,
                fontWeight = FontWeight.Medium,
                letterSpacing = 1.25.sp
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_two_dots),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = card.number.toString().takeLast(4),
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
                Text(
                    text = card.expirationDate,
                    style = MaterialTheme.typography.body2,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHighlightedBankCard() {
    BankCard(
        card = FinanceConstants.cards.first(),
        isHighlightedCard = true,
        onClick = { }
    )
}

@Preview
@Composable
fun PreviewBankCard() {
    Box(
        modifier = Modifier
            .background(Surface)
            .padding(16.dp)
    ) {
        BankCard(
            card = FinanceConstants.cards[1],
            isHighlightedCard = false,
            onClick = { }
        )
    }
}
