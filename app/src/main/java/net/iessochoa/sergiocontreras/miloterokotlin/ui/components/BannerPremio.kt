package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

/*
 * ============================================================================
 *  BannerPremio: el resultado de comprobar el cupón
 * ============================================================================
 *
 *  QUÉ SE PIDE
 *  -----------
 *  Un composable con una imagen a la izquierda y un mensaje a su derecha,
 *  centrados verticalmente. La imagen ocupa más o menos un tercio del ancho y
 *  el texto el resto:
 *
 *      ┌─────────┐
 *      │ imagen  │  ¡Felicidades! Has ganado 500000 €.
 *      └─────────┘  ¡Muchas gracias por jugar!
 *
 *  Según haya o no premio:
 *
 *  | Situación   | Imagen                         | Mensaje                                                          |
 *  |-------------|--------------------------------|------------------------------------------------------------------|
 *  | Con premio  | R.drawable.premio_dinero       | "¡Felicidades! Has ganado X €. ¡Muchas gracias por jugar!"       |
 *  | Sin premio  | R.drawable.sin_premio_monedero | "Vaya, esta vez no ha habido suerte. ¡Muchas gracias por jugar!" |
 *
 *  X = importe del premio en euros.
 *
 *  LAS IMÁGENES YA ESTÁN IMPORTADAS en `res/drawable-nodpi/`:
 *  `premio_dinero.png` y `sin_premio_monedero.png`. No tienes que añadir nada,
 *  solo usarlas con `painterResource(R.drawable.xxx)`.
 *
 *  NIVELES
 *  -------
 *  - Básico: imagen y mensaje visibles. Vale con imagen y texto fijos, siempre
 *    que al comprobar se vea si hay premio o no.
 *  - Avanzado: la imagen y el mensaje cambian según haya premio o no, y el
 *    mensaje incluye el importe. En este nivel el único premio es 500000 €.
 *  - Excelente: el importe sale de la tabla de premios completa. Si el
 *    componente recibe el importe por parámetro, no tendrás que tocarlo.
 *
 *  PISTAS
 *  ------
 *  - Este componente NO calcula nada ni guarda estado: recibe el resultado ya
 *    calculado por parámetro (p. ej. `premio: Int`, donde 0 = sin premio). El
 *    cálculo se hace en la pantalla (MainScreen).
 *  - Para decidir qué imagen y qué mensaje toca, basta con un `if` o un `when`.
 *  - Los textos ya están en `strings.xml`. El del premio lleva un hueco para el
 *    importe (`%1$d`); se rellena pasándolo a `stringResource`:
 *
 *        stringResource(R.string.mensaje_premio, premio)
 *
 *  - `Image` necesita un `contentDescription` para la accesibilidad. También
 *    están en `strings.xml` (`descripcion_imagen_premio`, `descripcion_imagen_sin_premio`).
 *  - Para repartir el ancho dentro del `Row`: `33%` en la imagen
 *    y 66% para el texto.
 *  - Acepta un `modifier: Modifier = Modifier` y añade dos `@Preview`: una
 *    con premio y otra sin premio.
 */
