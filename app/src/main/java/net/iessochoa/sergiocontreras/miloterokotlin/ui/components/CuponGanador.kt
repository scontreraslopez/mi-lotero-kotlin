package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

/*
 * ============================================================================
 *  CuponGanador: el número y la serie premiados en el sorteo
 * ============================================================================
 *
 *  QUÉ SE PIDE
 *  -----------
 *  Un composable que muestre en una fila, centrados, el número premiado (grande
 *  y en negrita) y, a su lado, la serie:
 *
 *              00256   Serie: 01
 *
 *  El número va siempre con 5 cifras y la serie con 2 (ceros a la izquierda).
 *
 *  NIVELES
 *  -------
 *  - Básico y Avanzado: vale con que se vea siempre.
 *  - Excelente: solo se ve después de pulsar "Comprobar cupón" (y se vuelve a
 *    ocultar con "Limpiar"). Ojo: eso lo decide la PANTALLA (MainScreen) con un
 *    `if`, no este componente.
 *
 *  PISTAS
 *  ------
 *  - Este componente NO sabe cuál es el cupón premiado ni guarda estado: recibe
 *    por parámetro lo que tiene que pintar (p. ej. `numero: String` y
 *    `serie: String`, ya formateados). El modelo `Cupon` ya te da
 *    `numeroFormateado` y `serieFormateada`: no vuelvas a formatear aquí.
 *  - Para el estilo, tira del tema en vez de poner tamaños a mano:
 *    `style = MaterialTheme.typography.headlineLarge`,
 *    `fontWeight = FontWeight.Bold`.
 *  - El texto de la serie ya está en `strings.xml` con un hueco de texto (`%1$s`):
 *
 *        stringResource(R.string.serie_formato, serie)
 *
 *  - Para separar los dos textos: un `Spacer` con ancho o
 *    `horizontalArrangement = Arrangement.spacedBy(...)` en el `Row`.
 *  - Acepta un `modifier: Modifier = Modifier` y añade una `@Preview` que use
 *    `SorteoRepository.cuponPremiado`.
 */
