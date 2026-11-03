package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

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
 *  - Usa `OutlinedTextField` (parámetros `value`, `onValueChange`, `label`).
 *  - Este componente NO guarda el texto (nada de `remember` aquí dentro).
 *    Recibe por parámetro:
 *      · el texto actual del número y de la serie,
 *      · una lambda para cada campo con la que avisar del texto nuevo
 *        (p. ej. `onNumeroChange: (String) -> Unit`).
 *    El estado vive en la pantalla (MainScreen).
 *  - Validar = decidir en `onValueChange` si aceptas el texto nuevo ANTES de
 *    avisar hacia arriba. Si no lo aceptas, simplemente no llames a la lambda.
 *    Te pueden servir `length` y `all { it.isDigit() }`.
 *  - Teclado numérico:
 *
 *        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
 *
 *    y `singleLine = true` para que no crezca hacia abajo.
 *  - El contador va en el parámetro `supportingText = { ... }`. El texto ya está
 *    en `strings.xml` con dos huecos (`%1$d / %2$d`). Los máximos (5 y 2) son
 *    buenos candidatos a constante para no repetirlos.
 *  - Para repartir el ancho dentro del `Row`: `Modifier.weight(...)` en cada campo.
 *  - Las etiquetas ya están en `strings.xml` (`etiqueta_numero`, `etiqueta_serie`).
 *  - Acepta un `modifier: Modifier = Modifier` y añade una `@Preview` con
 *    textos de ejemplo y lambdas vacías `{ }`.
 */
