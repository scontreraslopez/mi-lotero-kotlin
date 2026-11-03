package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.miloterokotlin.R

/*
 * ============================================================================
 *  CuponComprobar: los campos donde el jugador escribe su cupón
 * ============================================================================
 *
 *  QUÉ SE PIDE
 *  -----------
 *  Un composable con dos campos de texto en la misma fila: el número (más
 *  ancho) y la serie (más estrecho). Cada uno con su etiqueta y, debajo, un
 *  contador de caracteres:
 *
 *      ┌ Número ─────────────┐  ┌ Serie ───────┐
 *      │ 256                 │  │ 1            │
 *      └─────────────────────┘  └──────────────┘
 *        3 / 5                    1 / 2
 *
 *  NIVELES
 *  -------
 *  - Básico: los dos campos se ven con su etiqueta ("Número" y "Serie") y lo
 *    que escribe el jugador se queda escrito.
 *  - Avanzado: los campos se validan:
 *      · solo admiten dígitos,
 *      · el número tiene como máximo 5 caracteres y la serie 2,
 *      · al pulsarlos sale el teclado numérico,
 *      · debajo de cada uno se ve el contador "n / máx" (p. ej. "3 / 5").
 *
 *  PISTAS
 *  ------
 *  - Más abajo tienes `CampoEjemplo`: un `OutlinedTextField` ya montado con
 *    etiqueta, teclado numérico, una sola línea y contador. Úsalo como plantilla
 *    para tus dos campos (cópialo dentro de tu composable y adáptalo). Lo que
 *    NO trae, y te toca a ti:
 *      · `value`: ahora es un texto fijo; tiene que ser el texto del estado.
 *      · `onValueChange`: ahora no hace nada; tiene que avisar hacia arriba.
 *      · el contador: ahora pinta siempre "0 / 5".
 *    Cuando lo hayas usado, bórralo (si no, es código muerto).
 *  - Este componente NO guarda el texto (nada de `remember` aquí dentro).
 *    Recibe por parámetro:
 *      · el texto actual del número y de la serie,
 *      · una lambda para cada campo con la que avisar del texto nuevo
 *        (p. ej. `onNumeroChange: (String) -> Unit`).
 *    El estado vive en la pantalla (MainScreen).
 *  - Validar = decidir en `onValueChange` si aceptas el texto nuevo ANTES de
 *    avisar hacia arriba. Si no lo aceptas, simplemente no llames a la lambda.
 *    Te pueden servir `length` y `all { it.isDigit() }`.
 *  - Los máximos (5 y 2) son buenos candidatos a constante para no repetirlos.
 *  - Para repartir el ancho dentro del `Row`: `Modifier.weight(...)` en cada campo.
 *  - Las etiquetas y el contador ya están en `strings.xml` (`etiqueta_numero`,
 *    `etiqueta_serie`, `contador_caracteres`).
 *  - Acepta un `modifier: Modifier = Modifier` y añade una `@Preview` con
 *    textos de ejemplo y lambdas vacías `{ }`.
 */

/**
 * Plantilla de campo de texto para el cupón. **Viene de fábrica y no se evalúa.**
 *
 * Muestra el formato del `OutlinedTextField` que hay que usar, pero no está conectado
 * a nada: el texto es fijo y no reacciona al teclado. Cópialo en `CuponComprobar`,
 * conéctalo al estado y bórralo.
 */
@Composable
fun CampoEjemplo(modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = "", // TODO: el texto que viene del estado
        onValueChange = { }, // TODO: validar y avisar hacia arriba con una lambda
        label = { Text(stringResource(R.string.etiqueta_numero)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        supportingText = {
            // TODO: longitud real del texto y máximo del campo
            Text(stringResource(R.string.contador_caracteres, 0, 5))
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CampoEjemploPreview() = CampoEjemplo()
