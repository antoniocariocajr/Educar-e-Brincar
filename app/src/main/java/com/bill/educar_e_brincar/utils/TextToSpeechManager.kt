package com.bill.educar_e_brincar.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import java.util.Locale

object TextToSpeechManager {

    private var tts: TextToSpeech? = null
    private var isInitialized = false
    private var pendingText: String? = null // Guarda o texto se o TTS não estiver pronto

    var isMuted = mutableStateOf(false)
        private set

    fun initialize(context: Context) {
        if (isInitialized) return

        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale("pt", "BR")
                isInitialized = true
                // Se houver um texto pendente, fale agora
                pendingText?.let {
                    speak(it)
                    pendingText = null
                }
            } else {
                Log.e("TTS", "Falha na inicialização: $status")
            }
        }
    }

    fun speak(text: String) {
        if (isMuted.value) return

        if (isInitialized) {
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        } else {
            // Se não estiver inicializado, guarda o texto para ser falado depois
            pendingText = text
        }
    }

    fun toggleMute() {
        isMuted.value = !isMuted.value
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        isInitialized = false
        pendingText = null
    }
}
