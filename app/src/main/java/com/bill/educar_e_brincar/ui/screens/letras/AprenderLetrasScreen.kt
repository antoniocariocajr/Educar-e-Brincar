package com.bill.educar_e_brincar.ui.screens.letras

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

data class Letra(val letra: Char, val som: Int)

@Composable
fun AprenderLetrasScreen(navController: NavController) {
    val context = LocalContext.current
    val letras = listOf(
        Letra('A', R.raw.vogal_a),
        Letra('B', 0),
        Letra('C', 0),
        Letra('D', 0),
        Letra('E', R.raw.vogal_e),
        Letra('F', 0),
        Letra('G', 0),
        Letra('H', 0),
        Letra('I', R.raw.vogal_i),
        Letra('J', 0),
        Letra('K', 0),
        Letra('L', 0),
        Letra('M', 0),
        Letra('N', 0),
        Letra('O', R.raw.vogal_o),
        Letra('P', 0),
        Letra('Q', 0),
        Letra('R', 0),
        Letra('S', 0),
        Letra('T', 0),
        Letra('U', R.raw.vogal_u),
        Letra('V', 0),
        Letra('W', 0),
        Letra('X', 0),
        Letra('Y', 0),
        Letra('Z', 0)
    )

    var indiceAtual by remember { mutableStateOf(0) }
    val letraAtual = letras[indiceAtual]

    LaunchedEffect(indiceAtual) {
        SoundPlayer.playSound(context, letraAtual.som)
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
                text = letraAtual.letra.toString(),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 150.sp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    indiceAtual = if (indiceAtual > 0) indiceAtual - 1 else letras.size - 1
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Anterior")
                }
                Button(onClick = {
                    indiceAtual = if (indiceAtual < letras.size - 1) indiceAtual + 1 else 0
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Próximo")
                }
            }
        }
    }
}
