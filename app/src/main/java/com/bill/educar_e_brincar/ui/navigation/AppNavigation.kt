package com.bill.educar_e_brincar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bill.educar_e_brincar.ui.screens.CoresScreen
import com.bill.educar_e_brincar.ui.screens.FormasScreen
import com.bill.educar_e_brincar.ui.screens.AnimaisScreen
import com.bill.educar_e_brincar.ui.screens.HomeScreen
import com.bill.educar_e_brincar.ui.screens.LetrasScreen
import com.bill.educar_e_brincar.ui.screens.NumerosScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("cores") {
            CoresScreen(navController = navController)
        }
        composable("numeros") {
            NumerosScreen(navController = navController)
        }
        composable("formas") {
            FormasScreen(navController = navController)
        }
        composable("letras") {
            LetrasScreen(navController = navController)
        }
        composable("animais") {
            AnimaisScreen(navController = navController)
        }
    }
}
