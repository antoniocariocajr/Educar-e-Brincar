package com.bill.educar_e_brincar.ui.screens

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
import com.bill.educar_e_brincar.ui.theme.Coral
import com.bill.educar_e_brincar.ui.theme.CustomBlue
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme
import com.bill.educar_e_brincar.ui.theme.MediumAquamarine

@Composable
fun FormasScreen(navController: NavController, modifier: Modifier = Modifier) {
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
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = MediumAquamarine)) {
                        append("Conhecendo ")
                    }
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = CustomBlue)) {
                        append("as ")
                    }
                    withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = Coral)) {
                        append("Formas")
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )
            // TODO: Adicionar aqui os botões e o conteúdo da tela de Formas
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormasScreenPreview() {
    EducareBrincarTheme {
        FormasScreen(rememberNavController())
    }
}
