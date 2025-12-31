package com.bill.educar_e_brincar.ui.screens.formas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bill.educar_e_brincar.R
import com.bill.educar_e_brincar.utils.SoundPlayer

data class Forma(val nome: String, val som: Int, val desenha: @Composable () -> Unit)

@Composable
fun AprenderFormasScreen(navController: NavController) {
    val context = LocalContext.current
    val formas = listOf(
        Forma("Círculo", R.raw.circulo) { Circulo() },
        Forma("Quadrado", R.raw.quadrado) { Quadrado() },
        Forma("Triângulo", R.raw.triangulo) { Triangulo() },
        Forma("Retângulo", R.raw.retangulo) { Retangulo() },
        Forma("Estrela", R.raw.estrela) { Estrela() }
    )

    var indiceAtual by remember { mutableStateOf(0) }
    val formaAtual = formas[indiceAtual]

    LaunchedEffect(indiceAtual) {
        SoundPlayer.playSound(context, formaAtual.som)
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
            formaAtual.desenha()
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = formaAtual.nome, style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    indiceAtual = if (indiceAtual > 0) indiceAtual - 1 else formas.size - 1
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Anterior")
                }
                Button(onClick = {
                    indiceAtual = if (indiceAtual < formas.size - 1) indiceAtual + 1 else 0
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Próximo")
                }
            }
        }
    }
}

@Composable
fun Circulo() {
    Canvas(modifier = Modifier.size(150.dp)) {
        drawCircle(color = Color.Red)
    }
}

@Composable
fun Quadrado() {
    Canvas(modifier = Modifier.size(150.dp)) {
        drawRect(color = Color.Blue)
    }
}

@Composable
fun Triangulo() {
    Canvas(modifier = Modifier.size(150.dp)) {
        val path = Path().apply {
            moveTo(size.width / 2, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        drawPath(path, color = Color.Green)
    }
}

@Composable
fun Retangulo() {
    Canvas(modifier = Modifier.size(150.dp, 100.dp)) {
        drawRect(color = Color.Yellow)
    }
}

@Composable
fun Estrela() {
    Canvas(modifier = Modifier.size(150.dp)) {
        val path = Path().apply {
            moveTo(size.width / 2, 0f)
            lineTo(size.width * 0.6f, size.height * 0.4f)
            lineTo(size.width, size.height * 0.4f)
            lineTo(size.width * 0.7f, size.height * 0.65f)
            lineTo(size.width * 0.8f, size.height)
            lineTo(size.width / 2, size.height * 0.8f)
            lineTo(size.width * 0.2f, size.height)
            lineTo(size.width * 0.3f, size.height * 0.65f)
            lineTo(0f, size.height * 0.4f)
            lineTo(size.width * 0.4f, size.height * 0.4f)
            close()
        }
        drawPath(path, color = Color.Magenta)
    }
}
