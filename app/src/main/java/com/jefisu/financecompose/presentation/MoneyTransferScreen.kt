package com.jefisu.financecompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jefisu.financecompose.R
import com.jefisu.financecompose.data.FinanceConstants
import com.jefisu.financecompose.presentation.components.BankCard
import com.jefisu.financecompose.presentation.components.DottedCircle
import com.jefisu.financecompose.presentation.components.HeaderTopBar
import com.jefisu.financecompose.ui.theme.HighlightedCardColor
import com.jefisu.financecompose.ui.theme.Surface

@Composable
fun MoneyTransferScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.navigationBarsPadding()
    ) {
        HeaderTopBar(
            title = "Money transfer",
            onBackNavigateClick = navController::navigateUp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White.copy(0.1f))
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(16.dp),
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.2f),
                            Color.White.copy(alpha = 0.2f)
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Money transfer statistics",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "You sent 5% more money this month than last month",
                    color = Color.White.copy(0.3f),
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.body2
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(HighlightedCardColor)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_lightning_conflict),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Select person",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.padding(start = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DottedCircle()
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Add",
                        color = Color.LightGray
                    )
                }
            }
            items(FinanceConstants.people) { person ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(person.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = person.name,
                        color = Color.LightGray
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Choose card",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(FinanceConstants.cards) { card ->
                BankCard(
                    card = card,
                    isHighlightedCard = false,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = if (card == FinanceConstants.cards.last()) 20.dp else 0.dp
                    ),
                    onClick = { }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMoneyTransferScreen() {
    Surface(color = Surface, modifier = Modifier.fillMaxSize()) {
        MoneyTransferScreen(
            navController = rememberNavController()
        )
    }
}