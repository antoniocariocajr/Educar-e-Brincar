package com.bill.educar_e_brincar.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bill.educar_e_brincar.ui.screens.HomeScreen
import com.bill.educar_e_brincar.ui.screens.animais.AnimaisScreen
import com.bill.educar_e_brincar.ui.screens.animais.ConhecerAnimaisScreen
import com.bill.educar_e_brincar.ui.screens.cores.AprenderCoresScreen
import com.bill.educar_e_brincar.ui.screens.cores.CoresScreen
import com.bill.educar_e_brincar.ui.screens.desenhar.DesenharCanvasScreen
import com.bill.educar_e_brincar.ui.screens.formas.AprenderFormasScreen
import com.bill.educar_e_brincar.ui.screens.formas.FormasScreen
import com.bill.educar_e_brincar.ui.screens.letras.AprenderLetrasScreen
import com.bill.educar_e_brincar.ui.screens.letras.DesenharLetrasScreen
import com.bill.educar_e_brincar.ui.screens.letras.LetrasScreen
import com.bill.educar_e_brincar.ui.screens.numeros.AprenderNumerosScreen
import com.bill.educar_e_brincar.ui.screens.numeros.DesenharNumerosScreen
import com.bill.educar_e_brincar.ui.screens.numeros.NumerosScreen
import com.bill.educar_e_brincar.ui.screens.vogais.AprenderVogaisScreen
import com.bill.educar_e_brincar.ui.screens.vogais.DesenharVogaisScreen
import com.bill.educar_e_brincar.ui.screens.vogais.VogaisScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }

        // Rotas de Cores
        composable("cores") { CoresScreen(navController) }
        composable("aprender_cores") { AprenderCoresScreen(navController) }

        // Rotas de Números
        composable("numeros") { NumerosScreen(navController) }
        composable("aprender_numeros") { AprenderNumerosScreen(navController) }
        composable("desenhar_numeros") { DesenharNumerosScreen(navController) }

        // Rotas de Formas
        composable("formas") { FormasScreen(navController) }
        composable("aprender_formas") { AprenderFormasScreen(navController) }

        // Rotas de Letras
        composable("letras") { LetrasScreen(navController) }
        composable("aprender_letras") { AprenderLetrasScreen(navController) }
        composable("desenhar_letras") { DesenharLetrasScreen(navController) }

        // Rotas de Vogais
        composable("vogais") { VogaisScreen(navController) }
        composable("aprender_vogais") { AprenderVogaisScreen(navController) }
        composable("desenhar_vogais") { DesenharVogaisScreen(navController) }

        // Rotas de Animais
        composable("animais") { AnimaisScreen(navController) }
        composable("conhecer_animais") { ConhecerAnimaisScreen(navController) }

        // Rota genérica para Desenhar
        composable(
            route = "desenhar_canvas/{letra}",
            arguments = listOf(navArgument("letra") { type = NavType.StringType })
        ) { backStackEntry ->
            val letra = backStackEntry.arguments?.getString("letra")
            DesenharCanvasScreen(navController = navController, letter = letra)
        }
    }
}
