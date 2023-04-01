package com.jefisu.financecompose.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.jefisu.financecompose.R
import com.jefisu.financecompose.presentation.components.FlagCard
import java.time.Month

object FinanceConstants {

    val cards = listOf(
        Card(
            name = "Family",
            value = 4947.23f,
            flag = FlagCard.Visa,
            expirationDate = "09/30",
            number = 5434231328087463
        ),
        Card(
            name = "Salary",
            value = 2861.01f,
            flag = FlagCard.MasterCard,
            expirationDate = "08/29",
            number = 5435794328084049
        )
    )

    val recentActivities = listOf(
        RecentActivity(
            name = "Figma",
            icon = R.drawable.figma_logo,
            createdAt = 1679925855000,
            value = -676.93f
        ),
        RecentActivity(
            name = "Envato",
            icon = R.drawable.envato,
            createdAt = 1680113055000,
            value = -864.3f
        ),
        RecentActivity(
            name = "Dribbble",
            icon = R.drawable.dribbble_ball_icon,
            createdAt = 1680221055000,
            value = -950f
        )
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val monthSpends = listOf(
        MonthSpend(
            month = Month.JANUARY,
            percent = 0.65f,
            color = Color.White.copy(0.2f)
        ),
        MonthSpend(
            month = Month.FEBRUARY,
            percent = 0.20f,
            color = Color(0xFF2ACB90)
        ),
        MonthSpend(
            month = Month.MARCH,
            percent = 0.95f,
            color = Color(0xFF8045FF)
        ),
        MonthSpend(
            month = Month.APRIL,
            percent = 0.55f,
            color = Color(0xFFC66CFC)
        ),
        MonthSpend(
            month = Month.MAY,
            percent = 0.25f,
            color = Color(0xFFFCA06B)
        ),
        MonthSpend(
            month = Month.JUNE,
            percent = 0.65f,
            color = Color(0xFF30A9DE)
        ),
        MonthSpend(
            month = Month.JULY,
            percent = 0.35f,
            color = Color(0xFF2ACB90)
        ),
        MonthSpend(
            month = Month.AUGUST,
            percent = 0.77f,
            color = Color(0xFF8045FF)
        ),
        MonthSpend(
            month = Month.SEPTEMBER,
            percent = 0.44f,
            color = Color.White.copy(0.2f)
        ),
        MonthSpend(
            month = Month.OCTOBER,
            percent = 0.70f,
            color = Color(0xFFC66CFC)
        ),
        MonthSpend(
            month = Month.NOVEMBER,
            percent = 0.25f,
            color = Color(0xFFFCA06B)
        ),
        MonthSpend(
            month = Month.DECEMBER,
            percent = 0.21f,
            color = Color(0xFF30A9DE)
        )
    )

    val people = listOf(
        Person("Anne", R.drawable.person_2),
        Person("John", R.drawable.person_1),
        Person("David", R.drawable.person_3),
        Person("Jaden", R.drawable.person_4),
    )
}