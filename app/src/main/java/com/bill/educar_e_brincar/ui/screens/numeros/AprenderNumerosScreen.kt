package com.bill.educar_e_brincar.ui.screens.numeros

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bill.educar_e_brincar.R
import com.bill.educar_e_brincar.utils.SoundPlayer

data class Numero(val numero: Int, val som: Int)

@Composable
fun AprenderNumerosScreen(navController: NavController) {
    val context = LocalContext.current
    val numeros = listOf(
        Numero(1, R.raw.numero_1),
        Numero(2, R.raw.numero_2),
        Numero(3, R.raw.numero_3),
        Numero(4, R.raw.numero_4),
        Numero(5, R.raw.numero_5),
        Numero(6, R.raw.numero_6),
        Numero(7, R.raw.numero_7),
        Numero(8, R.raw.numero_8),
        Numero(9, R.raw.numero_9),
        Numero(10, R.raw.numero_10)
    )

    var indiceAtual by remember { mutableStateOf(0) }
    val numeroAtual = numeros[indiceAtual]

    LaunchedEffect(indiceAtual) {
        SoundPlayer.playSound(context, numeroAtual.som)
    }

    DisposableEffect(Unit) {
        onDispose {
            SoundPlayer.release()
        }
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
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = numeroAtual.numero.toString(),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 150.sp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    indiceAtual = if (indiceAtual > 0) indiceAtual - 1 else numeros.size - 1
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Anterior")
                }
                Button(onClick = {
                    indiceAtual = if (indiceAtual < numeros.size - 1) indiceAtual + 1 else 0
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Próximo")
                }
            }
        }
    }
}
