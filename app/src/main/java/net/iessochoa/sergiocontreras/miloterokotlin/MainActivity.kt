package net.iessochoa.sergiocontreras.miloterokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

/**
 * Punto de entrada de la app.
 *
 * **No hace falta tocarla.** La Activity solo arranca la app ([MiLoteroKotlinApp]):
 * aquí no va nada de UI. La pantalla se monta en `ui.screens.MainScreen`.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiLoteroKotlinApp()
        }
    }
}
