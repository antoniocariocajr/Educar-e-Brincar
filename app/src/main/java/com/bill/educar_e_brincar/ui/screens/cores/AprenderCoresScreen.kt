package com.bill.educar_e_brincar.ui.screens.cores

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bill.educar_e_brincar.ui.theme.*
import com.bill.educar_e_brincar.utils.TextToSpeechManager

data class Cor(val nome: String, val cor: Color)

@Composable
fun AprenderCoresScreen(navController: NavController) {
    val cores = listOf(
        Cor("Vermelho", Red),
        Cor("Verde", Green),
        Cor("Azul", Blue),
        Cor("Amarelo", Yellow),
        Cor("Laranja", Orange),
        Cor("Roxo", Purple),
        Cor("Rosa", Pink),
        Cor("Marrom", Brown),
        Cor("Preto", Black),
        Cor("Branco", White)
    )

    var indiceAtual by remember { mutableIntStateOf(0) }
    val corAtual = cores[indiceAtual]

    LaunchedEffect(indiceAtual) {
        TextToSpeechManager.speak(corAtual.nome)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(corAtual.cor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = corAtual.nome,
                style = MaterialTheme.typography.headlineLarge,
                color = if (corAtual.cor == Black) White else Black
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    indiceAtual = if (indiceAtual > 0) indiceAtual - 1 else cores.size - 1
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Anterior")
                }
                Button(onClick = {
                    indiceAtual = if (indiceAtual < cores.size - 1) indiceAtual + 1 else 0
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Próximo")
                }
            }
        }
    }
}
