package net.iessochoa.sergiocontreras.miloterokotlin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.iessochoa.sergiocontreras.miloterokotlin.ui.screens.MainScreen
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme

/**
 * Raíz de la app: aplica el tema y monta el `Scaffold` con la pantalla principal.
 *
 * TODO (Avanzado): añade una barra superior al `Scaffold` con el título
 * "Mi Lotero Kotlin" (`R.string.app_name`).
 *
 *  - El `Scaffold` tiene un parámetro `topBar = { ... }`.
 *  - Puedes usar `TopAppBar` o `CenterAlignedTopAppBar` (título centrado).
 *  - Son APIs experimentales: el IDE te pedirá añadir
 *    `@OptIn(ExperimentalMaterial3Api::class)` sobre la función.
 *  - No borres el `.padding(innerPadding)`: es lo que evita que la barra tape
 *    el contenido.
 */
@Composable
fun MiLoteroKotlinApp() {
    MiLoteroKotlinTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            MainScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}
