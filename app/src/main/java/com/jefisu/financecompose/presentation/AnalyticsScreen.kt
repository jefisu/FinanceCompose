package com.jefisu.financecompose.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jefisu.financecompose.R
import com.jefisu.financecompose.data.FinanceConstants
import com.jefisu.financecompose.presentation.components.HeaderTopBar
import com.jefisu.financecompose.presentation.components.RecentActivityItem
import com.jefisu.financecompose.presentation.util.formatCurrency
import com.jefisu.financecompose.ui.theme.Purple200
import com.jefisu.financecompose.ui.theme.Surface

@SuppressLint("NewApi")
@Composable
fun AnalyticsScreen(
    navController: NavController
) {

    Column {
        HeaderTopBar(
            title = "Analytics",
            onBackNavigateClick = navController::navigateUp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.White.copy(0.1f))
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(24.dp),
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.2f),
                            Color.White.copy(alpha = 0.2f)
                        )
                    )
                )
                .padding(vertical = 20.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Monthly Spend",
                    fontWeight = FontWeight.Medium,
                    color = Color.White.copy(0.4f),
                    fontSize = 18.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF322B4D))
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_play),
                        contentDescription = null,
                        tint = Color(0xFF9BD4BA),
                        modifier = Modifier
                            .size(16.dp)
                            .rotate(-90f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "+15.03%",
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF9BD4BA),
                        fontSize = 16.sp
                    )
                }
            }
            Text(
                text = formatCurrency(11783f, 28.sp),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(FinanceConstants.monthSpends) { monthSpend ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                end = if (monthSpend == FinanceConstants.monthSpends.last()) 16.dp else 0.dp
                            )
                            .width(40.dp)
                            .height(210.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height((190 * monthSpend.percent).dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(monthSpend.color)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = monthSpend.month.name
                                .take(3)
                                .lowercase()
                                .replaceFirstChar { it.titlecase() },
                            fontSize = 14.sp,
                            color = Color.White.copy(0.4f)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(36.dp, 36.dp))
                .background(Color.White.copy(0.1f))
                .navigationBarsPadding()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 20.dp
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Transactions",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
                Text(
                    text = "See all",
                    style = MaterialTheme.typography.subtitle1,
                    color = Purple200,
                    fontWeight = FontWeight.Bold
                )
            }
            FinanceConstants.recentActivities.forEach { recentActivity ->
                RecentActivityItem(
                    name = recentActivity.name,
                    createdAt = recentActivity.createdAt,
                    value = recentActivity.value,
                    icon = recentActivity.icon,
                    backgroundColor = Surface,
                    modifier = Modifier.padding(top = 12.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAnalyticsScreen() {
    Surface(color = Surface, modifier = Modifier.fillMaxSize()) {
        AnalyticsScreen(
            navController = rememberNavController()
        )
    }
}