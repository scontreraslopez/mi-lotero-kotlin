package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

/*
 * ============================================================================
 *  FilaBotones: botones para comprobar el cupón y limpiar el formulario
 * ============================================================================
 *
 *  QUÉ SE PIDE
 *  -----------
 *  Un composable con dos botones en la misma fila, centrados y con una
 *  pequeña separación entre ellos:
 *
 *      ┌───────────────────┐  ┌─────────┐
 *      │  Comprobar cupón  │  │ Limpiar │
 *      └───────────────────┘  └─────────┘
 *
 *  NIVELES
 *  -------
 *  - Básico: los dos botones se ven con sus textos. "Comprobar cupón" comprueba
 *    el cupón (eso lo hace la pantalla).
 *  - Avanzado: cada botón muestra su Toast.
 *      · Comprobar cupón → "Cupón comprobado"
 *      · Limpiar         → "Formulario limpiado"
 *  - Excelente:
 *      · "Limpiar" deja la pantalla como al principio (campos vacíos y sin
 *        resultado).
 *      · "Comprobar cupón" está deshabilitado mientras falte el número o la
 *        serie.
 *
 *  PISTAS
 *  ------
 *  - Este componente NO sabe qué pasa al pulsar: recibe una lambda por cada
 *    botón (p. ej. `onComprobarClick: () -> Unit`) y la llama en el `onClick`.
 *    El Toast y la limpieza se hacen en la pantalla (MainScreen), que es
 *    quien tiene el estado y el `Context`.
 *  - Para deshabilitar un botón, `Button` tiene el parámetro `enabled`. Este
 *    componente no decide si está habilitado: lo recibe por parámetro
 *    (p. ej. `comprobarHabilitado: Boolean`).
 *  - Los textos de los botones van en `strings.xml` y se leen con
 *    `stringResource(...)`.
 *  - Acepta un `modifier: Modifier = Modifier` y añade una `@Preview` con
 *    lambdas vacías `{ }`.
 */
