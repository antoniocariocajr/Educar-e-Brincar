package com.bill.educar_e_brincar.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bill.educar_e_brincar.ui.theme.Coral
import com.bill.educar_e_brincar.ui.theme.CustomBlue
import com.bill.educar_e_brincar.ui.theme.DodgerBlue
import com.bill.educar_e_brincar.ui.theme.Goldenrod
import com.bill.educar_e_brincar.ui.theme.LightPink
import com.bill.educar_e_brincar.ui.theme.MediumAquamarine
import com.bill.educar_e_brincar.ui.theme.MediumSpringGreen
import com.bill.educar_e_brincar.utils.TextToSpeechManager

@Composable
fun CategoryMenuScreen(
    navController: NavController,
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val context = LocalContext.current
    val vibrantColors = listOf(
        Coral, CustomBlue, DodgerBlue, Goldenrod, LightPink, MediumAquamarine, MediumSpringGreen
    )

    LaunchedEffect(Unit) {
        TextToSpeechManager.initialize(context)
        TextToSpeechManager.speak(title)
    }

    DisposableEffect(Unit) {
        onDispose {
            // Libera os recursos do TTS quando a tela é descartada
            TextToSpeechManager.shutdown()
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
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        title.forEach { char ->
                            withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = vibrantColors.random())) {
                                append(char)
                            }
                        }
                    },
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.Center)
                )
                Box(modifier = Modifier.align(Alignment.CenterEnd).padding(end = 16.dp)) {
                   MuteButton()
                }
            }

            // O conteúdo específico (botões) da tela será inserido aqui
            content()
        }
    }
}
