package net.iessochoa.sergiocontreras.miloterokotlin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/*
 * ============================================================================
 *  MainScreen: la pantalla de comprobación del cupón
 * ============================================================================
 *
 *  QUÉ SE PIDE
 *  -----------
 *  Esta pantalla monta los componentes de `ui.components` y es la ÚNICA que
 *  guarda el estado. Los componentes solo pintan y avisan.
 *
 *  Orden de arriba abajo:
 *
 *      Título "Cupón ganador"   (un Text con `MaterialTheme.typography.headlineLarge`)
 *      CuponGanador
 *      BannerPremio
 *      CuponComprobar
 *      FilaBotones
 *
 *  En Excelente, hasta que se pulse "Comprobar cupón", en lugar de
 *  CuponGanador y BannerPremio se ve el texto "Pulse para comprobar su premio".
 *
 *  Pon `Spacer`s entre los elementos para que la pantalla respire, p. ej.
 *  `Spacer(modifier = Modifier.height(16.dp))`. Juega con las alturas hasta
 *  que quede bien.
 *
 *  SUGERENCIA DE PASOS
 *  -------------------
 *  1. Datos: pide el cupón premiado a `SorteoRepository`.          → Básico
 *
 *  2. Estado:
 *       - el texto del número y el de la serie que escribe el jugador → Básico
 *       - el resultado de la última comprobación (p. ej. el premio
 *         en euros, `mutableIntStateOf(0)`)                         → Básico
 *       - si ya se ha pulsado "Comprobar cupón" (`Boolean`)         → Excelente
 *
 *  3. Lambdas de los campos: cuando `CuponComprobar` avise de un texto
 *     nuevo, guárdalo en el estado.                                   → Básico
 *
 *  4. Botón "Comprobar cupón": compara lo escrito con el cupón premiado y
 *     guarda el resultado en el estado.
 *       - Básico / Avanzado: número Y serie coinciden → 500000 €; si no, 0.
 *       - Avanzado: además, Toast "Cupón comprobado".
 *       - Excelente: tabla de premios completa (la tienes en el KDoc de
 *         `SorteoRepository`) y marcar que ya se ha comprobado.
 *     Ojo: el resultado se calcula al PULSAR, no en cada recomposición. Si lo
 *     calculas suelto en el cuerpo de la función, cambiaría mientras escribes.
 *     Por eso se guarda en el estado.
 *
 *  5. Botón "Limpiar":
 *       - Avanzado: Toast "Formulario limpiado".
 *       - Excelente: vaciar los campos y volver a ocultar el resultado.
 *
 *  6. Datos derivados, calculados a partir del estado en cada recomposición
 *     (no hace falta guardarlos en otro `remember`):
 *       - ¿se puede comprobar? (número y serie no vacíos, `isNotEmpty()`)
 *                                                                     → Excelente
 *
 *  PISTAS PARA LOS TOAST
 *  ---------------------
 *  - El `Context` se obtiene con `val context = LocalContext.current`.
 *  - `stringResource(...)` es `@Composable`: NO se puede llamar dentro de un
 *    `onClick`. Lee el texto ANTES, fuera de la lambda, y guárdalo en una `val`.
 *  - `Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()`
 */
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO: monta aquí la pantalla
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() = MainScreen(
    modifier = Modifier.fillMaxSize()
)
