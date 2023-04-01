package com.jefisu.financecompose.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jefisu.financecompose.R
import com.jefisu.financecompose.presentation.util.formatCurrency
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RecentActivityItem(
    name: String,
    createdAt: Long,
    value: Float,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White.copy(0.1f)
) {
    val disabledColor = Color.White.copy(0.4f)
    val date = DateFormat
        .getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        .format(createdAt)
    val hour = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(createdAt)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(backgroundColor)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = date,
                fontWeight = FontWeight.Medium,
                color = disabledColor,
                fontSize = 14.sp
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = formatCurrency(value, 18.sp),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = hour,
                fontWeight = FontWeight.Medium,
                color = disabledColor,
                fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewRecentActivityItem() {
    RecentActivityItem(
        icon = R.drawable.figma_logo,
        name = "Figma",
        createdAt = System.currentTimeMillis(),
        value = 17f,
        modifier = Modifier.fillMaxWidth()
    )
}