package com.bill.educar_e_brincar.ui.screens.vogais

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

data class Vogal(val vogal: Char, val som: Int)

@Composable
fun AprenderVogaisScreen(navController: NavController) {
    val context = LocalContext.current
    val vogais = listOf(
        Vogal('A', R.raw.vogal_a),
        Vogal('E', R.raw.vogal_e),
        Vogal('I', R.raw.vogal_i),
        Vogal('O', R.raw.vogal_o),
        Vogal('U', R.raw.vogal_u)
    )

    var indiceAtual by remember { mutableStateOf(0) }
    val vogalAtual = vogais[indiceAtual]

    LaunchedEffect(indiceAtual) {
        SoundPlayer.playSound(context, vogalAtual.som)
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
                text = vogalAtual.vogal.toString(),
                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 150.sp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    indiceAtual = if (indiceAtual > 0) indiceAtual - 1 else vogais.size - 1
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Anterior")
                }
                Button(onClick = {
                    indiceAtual = if (indiceAtual < vogais.size - 1) indiceAtual + 1 else 0
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Próximo")
                }
            }
        }
    }
}
