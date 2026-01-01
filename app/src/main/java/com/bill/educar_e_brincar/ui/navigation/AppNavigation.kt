package com.bill.educar_e_brincar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bill.educar_e_brincar.ui.screens.animais.AnimaisScreen
import com.bill.educar_e_brincar.ui.screens.cores.CoresScreen
import com.bill.educar_e_brincar.ui.screens.formas.FormasScreen
import com.bill.educar_e_brincar.ui.screens.HomeScreen
import com.bill.educar_e_brincar.ui.screens.animais.ConhecerAnimaisScreen
import com.bill.educar_e_brincar.ui.screens.letras.LetrasScreen
import com.bill.educar_e_brincar.ui.screens.numeros.NumerosScreen
import com.bill.educar_e_brincar.ui.screens.cores.AprenderCoresScreen
import com.bill.educar_e_brincar.ui.screens.desenhar.DesenharCanvasScreen
import com.bill.educar_e_brincar.ui.screens.formas.AprenderFormasScreen
import com.bill.educar_e_brincar.ui.screens.letras.AprenderLetrasScreen
import com.bill.educar_e_brincar.ui.screens.letras.DesenharLetrasScreen
import com.bill.educar_e_brincar.ui.screens.numeros.AprenderNumerosScreen
import com.bill.educar_e_brincar.ui.screens.numeros.DesenharNumerosScreen
import com.bill.educar_e_brincar.ui.screens.vogais.AprenderVogaisScreen
import com.bill.educar_e_brincar.ui.screens.vogais.DesenharVogaisScreen
import com.bill.educar_e_brincar.ui.screens.vogais.VogaisScreen

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
        composable("vogais") {
            VogaisScreen(navController = navController)
        }
        composable("animais") {
            AnimaisScreen(navController = navController)
        }
        composable("aprender_cores") {
            AprenderCoresScreen(navController = navController)
        }
        composable("aprender_formas") {
            AprenderFormasScreen(navController = navController)
        }
        composable("aprender_letras") {
            AprenderLetrasScreen(navController = navController)
        }
        composable("aprender_vogais") {
            AprenderVogaisScreen(navController = navController)
        }
        composable("aprender_numeros") {
            AprenderNumerosScreen(navController = navController)
        }
        composable("conhecer_animais") {
            ConhecerAnimaisScreen(navController = navController)
        }
        composable("desenhar_letras") {
            DesenharLetrasScreen(navController = navController)
        }
        composable("desenhar_vogais") {
            DesenharVogaisScreen(navController = navController)
        }
        composable("desenhar_numeros") {
            DesenharNumerosScreen(navController = navController)
        }
        composable(
            route = "desenhar_canvas/{letra}",
            arguments = listOf(navArgument("letra") { type = NavType.StringType })
        ) { backStackEntry ->
            val letra = backStackEntry.arguments?.getString("letra")
            DesenharCanvasScreen(navController = navController, letter = letra)
        }
    }
}
