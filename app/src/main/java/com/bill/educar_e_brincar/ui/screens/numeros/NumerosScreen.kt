package com.bill.educar_e_brincar.ui.screens.numeros

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bill.educar_e_brincar.ui.theme.DodgerBlue
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme
import com.bill.educar_e_brincar.ui.theme.Goldenrod
import com.bill.educar_e_brincar.ui.theme.MediumAquamarine

@Composable
fun NumerosScreen(navController: NavController, modifier: Modifier = Modifier) {
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
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = DodgerBlue)) {
                        append("os ")
                    }
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = MediumAquamarine)) {
                        append("Números")
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(48.dp))

            AppButton(
                onClick = { navController.navigate("aprender_numeros") },
                text = "Aprender",
                colors = ButtonDefaults.buttonColors(containerColor = Yellow, contentColor = DodgerBlue)
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
