package com.bill.educar_e_brincar.ui.screens.vogais

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bill.educar_e_brincar.ui.components.AppButton
import com.bill.educar_e_brincar.ui.theme.*

@Composable
fun VogaisScreen(navController: NavController, modifier: Modifier = Modifier) {
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
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = DarkBlue)) {
                        append("Conhecendo ")
                    }
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = LightPink)) {
                        append("as ")
                    }
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = MediumSpringGreen)) {
                        append("Vogais")
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(48.dp))

            AppButton(
                onClick = { navController.navigate("aprender_vogais") },
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
