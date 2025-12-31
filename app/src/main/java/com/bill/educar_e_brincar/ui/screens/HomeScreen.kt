package com.bill.educar_e_brincar.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
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
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme
import com.bill.educar_e_brincar.ui.theme.AliceBlue
import com.bill.educar_e_brincar.ui.theme.Coral
import com.bill.educar_e_brincar.ui.theme.Goldenrod
import com.bill.educar_e_brincar.ui.theme.MediumSpringGreen

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AliceBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = MediumSpringGreen)) {
                    append("Aprender ")
                }
                withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = Goldenrod)) {
                    append("e ")
                }
                withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle().copy(color = Coral)) {
                    append("Brincar")
                }
            },
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(48.dp))

        AppButton(onClick = { navController.navigate("cores") }, text = "Cores")
        Spacer(modifier = Modifier.height(24.dp))
        AppButton(onClick = { navController.navigate("numeros") }, text = "Números")
        Spacer(modifier = Modifier.height(24.dp))
        AppButton(onClick = { navController.navigate("formas") }, text = "Formas")
        Spacer(modifier = Modifier.height(24.dp))
        AppButton(onClick = { navController.navigate("letras") }, text = "Letras")
        Spacer(modifier = Modifier.height(24.dp))
        AppButton(onClick = { navController.navigate("animais") }, text = "Animais")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    EducareBrincarTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}
