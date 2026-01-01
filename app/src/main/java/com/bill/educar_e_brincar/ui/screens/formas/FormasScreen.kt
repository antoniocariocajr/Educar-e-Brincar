package com.bill.educar_e_brincar.ui.screens.formas

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bill.educar_e_brincar.ui.components.AppButton
import com.bill.educar_e_brincar.ui.theme.Coral
import com.bill.educar_e_brincar.ui.theme.CustomBlue
import com.bill.educar_e_brincar.ui.theme.DodgerBlue
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme
import com.bill.educar_e_brincar.ui.theme.LightYellow
import com.bill.educar_e_brincar.ui.theme.MediumAquamarine
import com.bill.educar_e_brincar.ui.theme.Red
import com.bill.educar_e_brincar.ui.theme.Yellow

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
            Spacer(modifier = Modifier.height(48.dp))

            AppButton(
                onClick = { navController.navigate("aprender_formas") },
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
fun FormasScreenPreview() {
    EducareBrincarTheme {
        FormasScreen(rememberNavController())
    }
}
