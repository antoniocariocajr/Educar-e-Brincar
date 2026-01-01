package com.bill.educar_e_brincar.ui.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private data class DrawnPath(val path: Path, val color: Color = Color.Black, val strokeWidth: Float = 12f)

@Composable
fun DrawingCanvas(modifier: Modifier = Modifier, guideLetter: String? = null) {
    val paths = remember { mutableStateListOf<DrawnPath>() }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.White)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = {
                            paths.add(DrawnPath(path = Path().apply { moveTo(it.x, it.y) }))
                        },
                        onDrag = { change, _ ->
                            paths.lastOrNull()?.let { lastDrawnPath ->
                                // Maneira correta de copiar um Path: criar um novo e usar addPath().
                                val newPath = Path().apply {
                                    addPath(lastDrawnPath.path)
                                    lineTo(change.position.x, change.position.y)
                                }
                                paths[paths.lastIndex] = lastDrawnPath.copy(path = newPath)
                            }
                        },
                        onDragEnd = { /* Stroke is finished */ }
                    )
                }
        ) {
            // Draw the guide letter in the background
            guideLetter?.let {
                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        guideLetter,
                        size.width / 2,
                        size.height / 2 + 150.sp.toPx() / 2, // Center the text
                        Paint().apply {
                            color = android.graphics.Color.LTGRAY
                            textSize = 150.sp.toPx()
                            textAlign = Paint.Align.CENTER
                        }
                    )
                }
            }

            // Draw the user's paths on top
            paths.forEach { drawnPath ->
                drawPath(
                    path = drawnPath.path,
                    color = drawnPath.color,
                    style = Stroke(
                        width = drawnPath.strokeWidth,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { paths.clear() }) {
            Text("Limpar")
        }
    }
}
