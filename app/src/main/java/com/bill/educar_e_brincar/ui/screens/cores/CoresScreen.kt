package com.bill.educar_e_brincar.ui.screens.cores

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bill.educar_e_brincar.ui.components.AppButton
import com.bill.educar_e_brincar.ui.components.CategoryMenuScreen
import com.bill.educar_e_brincar.ui.theme.Blue
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme
import com.bill.educar_e_brincar.ui.theme.Red
import com.bill.educar_e_brincar.ui.theme.Yellow

@Composable
fun CoresScreen(navController: NavController, modifier: Modifier = Modifier) {

    // Toca o áudio de introdução quando a tela é iniciada
    LaunchedEffect(Unit) {
        // TODO: Adicionar a lógica de reprodução de áudio aqui
        Log.d("Audio", "Tocando: Vamos aprender sobre as cores brincando.")
    }

    CategoryMenuScreen(
        navController = navController,
        title = "Conhecendo as Cores",
        modifier = modifier
    ) {
        // Conteúdo específico para a tela de Cores
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppButton(
                onClick = { navController.navigate("aprender_cores") },
                text = "Aprender",
                colors = ButtonDefaults.buttonColors(containerColor = Yellow, contentColor = Color.Black)
            )
            Spacer(modifier = Modifier.height(24.dp))
            AppButton(
                onClick = { /* TODO: Ação Misturar */ },
                text = "Misturar",
                colors = ButtonDefaults.buttonColors(containerColor = Blue, contentColor = Color.White)
            )
            Spacer(modifier = Modifier.height(24.dp))
            AppButton(
                onClick = { /* TODO: Ação Brincar */ },
                text = "Brincar",
                colors = ButtonDefaults.buttonColors(containerColor = Red, contentColor = Color.White)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoresScreenPreview() {
    EducareBrincarTheme {
        CoresScreen(rememberNavController())
    }
}
