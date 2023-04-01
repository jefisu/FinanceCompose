package com.jefisu.financecompose.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jefisu.financecompose.R
import com.jefisu.financecompose.Screen
import com.jefisu.financecompose.data.FinanceConstants
import com.jefisu.financecompose.presentation.components.BankCard
import com.jefisu.financecompose.presentation.components.RecentActivityItem
import com.jefisu.financecompose.ui.theme.BackgroundImage
import com.jefisu.financecompose.ui.theme.Purple200
import com.jefisu.financecompose.ui.theme.Surface

@Composable
fun HomeScreen(
    navController: NavController
) {
    val headerHeight = 50.dp
    val disabledColor = Color.White.copy(0.4f)
    val space = 20.dp

    Column(
        modifier = Modifier.navigationBarsPadding()
    ) {
        Spacer(modifier = Modifier.height(space))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight)
                .padding(horizontal = space)
        ) {
            Surface(
                shape = CircleShape, color = BackgroundImage
            ) {
                Image(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(headerHeight)
                        .offset(y = 5.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text(
                    text = "$7,897.00",
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
                Text(
                    text = "0,00035 BTC",
                    color = disabledColor
                )
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White.copy(0.2f))
                    .clickable { navController.navigate(Screen.MoneyTransfer.route) }
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_category),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "My cards",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = space)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(FinanceConstants.cards) { card ->
                BankCard(
                    card = card,
                    isHighlightedCard = card == FinanceConstants.cards.first(),
                    modifier = Modifier.padding(
                        start = space,
                        end = if (card == FinanceConstants.cards.last()) space else 0.dp
                    ),
                    onClick = { }
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = space)
        ) {
            Text(
                text = "Recent activity",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
            Text(
                text = "See all",
                style = MaterialTheme.typography.subtitle1,
                color = Purple200,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { navController.navigate(Screen.Analytics.route) }
            )
        }
        FinanceConstants.recentActivities.forEach { recentActivity ->
            RecentActivityItem(
                name = recentActivity.name,
                createdAt = recentActivity.createdAt,
                value = recentActivity.value,
                icon = recentActivity.icon,
                modifier = Modifier
                    .padding(horizontal = space)
                    .padding(top = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    Surface(color = Surface, modifier = Modifier.fillMaxSize()) {
        HomeScreen(
            navController = rememberNavController()
        )
    }
}