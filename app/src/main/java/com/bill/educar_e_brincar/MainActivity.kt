package com.bill.educar_e_brincar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bill.educar_e_brincar.ui.navigation.AppNavigation
import com.bill.educar_e_brincar.ui.theme.EducareBrincarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducareBrincarTheme {
                AppNavigation()
            }
        }
    }
}
