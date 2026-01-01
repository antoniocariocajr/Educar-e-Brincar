package com.bill.educar_e_brincar.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.bill.educar_e_brincar.utils.TextToSpeechManager

@Composable
fun MuteButton() {
    val isMuted by TextToSpeechManager.isMuted

    IconButton(onClick = { TextToSpeechManager.toggleMute() }) {
        Icon(
            imageVector = if (isMuted) Icons.AutoMirrored.Filled.VolumeOff else Icons.AutoMirrored.Filled.VolumeUp,
            contentDescription = if (isMuted) "Ativar som" else "Desativar som"
        )
    }
}
