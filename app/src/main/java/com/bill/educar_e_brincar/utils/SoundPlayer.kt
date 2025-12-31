package com.bill.educar_e_brincar.utils

import android.content.Context
import android.media.MediaPlayer

object SoundPlayer {
    private var mediaPlayer: MediaPlayer? = null

    fun playSound(context: Context, soundResId: Int) {
        if (soundResId != 0) {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(context, soundResId)
            mediaPlayer?.start()
        }
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
