package com.bill.educar_e_brincar.ui.screens.animais

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bill.educar_e_brincar.ui.components.AppButton
import com.bill.educar_e_brincar.ui.components.CategoryMenuScreen
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme
import com.bill.educar_e_brincar.ui.theme.Yellow

@Composable
fun AnimaisScreen(navController: NavController, modifier: Modifier = Modifier) {
    CategoryMenuScreen(
        navController = navController,
        title = "Conhecendo os Animais",
        modifier = modifier
    ) {
        // Conteúdo específico para a tela de Animais
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppButton(
                onClick = { navController.navigate("conhecer_animais") },
                text = "Conhecer",
                colors = ButtonDefaults.buttonColors(containerColor = Yellow, contentColor = Color.Black)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimaisScreenPreview() {
    EducareBrincarTheme {
        AnimaisScreen(rememberNavController())
    }
}
