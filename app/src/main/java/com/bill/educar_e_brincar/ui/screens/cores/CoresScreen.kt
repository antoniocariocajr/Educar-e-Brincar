package com.bill.educar_e_brincar.ui.screens.cores

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bill.educar_e_brincar.ui.components.AppButton
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme
import com.bill.educar_e_brincar.ui.theme.Blue
import com.bill.educar_e_brincar.ui.theme.CustomBlue
import com.bill.educar_e_brincar.ui.theme.DodgerBlue
import com.bill.educar_e_brincar.ui.theme.Goldenrod
import com.bill.educar_e_brincar.ui.theme.LightPink
import com.bill.educar_e_brincar.ui.theme.LightYellow
import com.bill.educar_e_brincar.ui.theme.Red
import com.bill.educar_e_brincar.ui.theme.Salmon
import com.bill.educar_e_brincar.ui.theme.Yellow

@Composable
fun CoresScreen(navController: NavController, modifier: Modifier = Modifier) {

    // Toca o áudio de introdução quando a tela é iniciada
    LaunchedEffect(Unit) {
        // TODO: Adicionar a lógica de reprodução de áudio aqui
        Log.d("Audio", "Tocando: Vamos aprender sobre as cores brincando.")
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = Goldenrod)) {
                        append("Conhecendo ")
                    }
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = CustomBlue)) {
                        append("as ")
                    }
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = Salmon)) {
                        append("Cores")
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(48.dp))

            AppButton(
                onClick = { navController.navigate("aprender_cores") },
                text = "Aprender",
                colors = ButtonDefaults.buttonColors(containerColor = Yellow, contentColor = DodgerBlue)
            )
            Spacer(modifier = Modifier.height(24.dp))
            AppButton(
                onClick = { /* TODO: Ação Misturar */ },
                text = "Misturar",
                colors = ButtonDefaults.buttonColors(containerColor = Blue, contentColor = LightPink)
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
fun CoresScreenPreview() {
    EducareBrincarTheme {
        CoresScreen(rememberNavController())
    }
}
