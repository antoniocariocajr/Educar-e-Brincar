package com.bill.educar_e_brincar.ui.screens.numeros

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bill.educar_e_brincar.ui.components.AppButton
import com.bill.educar_e_brincar.ui.components.CategoryMenuScreen
import com.bill.educar_e_brincar.ui.theme.Blue
import com.bill.educar_e_brincar.ui.theme.DodgerBlue
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme
import com.bill.educar_e_brincar.ui.theme.LightYellow
import com.bill.educar_e_brincar.ui.theme.Red
import com.bill.educar_e_brincar.ui.theme.White
import com.bill.educar_e_brincar.ui.theme.Yellow

@Composable
fun NumerosScreen(navController: NavController, modifier: Modifier = Modifier) {
    CategoryMenuScreen(
        navController = navController,
        title = "Conhecendo os Números",
        modifier = modifier
    ) {
        // Conteúdo específico para a tela de Números
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppButton(
                onClick = { navController.navigate("aprender_numeros")},
                text = "Aprender",
                colors = ButtonDefaults.buttonColors(containerColor = Yellow, contentColor = DodgerBlue)
            )
            Spacer(modifier = Modifier.height(24.dp))
            AppButton(
                onClick = { navController.navigate("desenhar_numeros") },
                text = "Desenhar",
                colors = ButtonDefaults.buttonColors(containerColor = Blue, contentColor = White)
            )
            Spacer(modifier = Modifier.height(24.dp))
            AppButton(
                onClick = { /* TODO: Ação Brincar */ },
                text = "Brincar",
                colors = ButtonDefaults.buttonColors(containerColor = Red, contentColor = LightYellow)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NumerosScreenPreview() {
    EducareBrincarTheme {
        NumerosScreen(rememberNavController())
    }
}
