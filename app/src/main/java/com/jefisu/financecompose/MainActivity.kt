package com.jefisu.financecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jefisu.financecompose.presentation.AnalyticsScreen
import com.jefisu.financecompose.presentation.HomeScreen
import com.jefisu.financecompose.presentation.MoneyTransferScreen
import com.jefisu.financecompose.ui.theme.FinanceComposeTheme
import com.jefisu.financecompose.ui.theme.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            FinanceComposeTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Surface)
                        .statusBarsPadding()
                ) {
                    composable(Screen.Home.route) {
                        HomeScreen(navController = navController)
                    }
                    composable(Screen.Analytics.route) {
                        AnalyticsScreen(navController = navController)
                    }
                    composable(Screen.MoneyTransfer.route) {
                        MoneyTransferScreen(navController = navController)
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Analytics : Screen("analytics_screen")
    object MoneyTransfer : Screen("money_transfer_screen")
}