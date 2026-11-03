# Mi Lotero Kotlin

Parcial 1 de la asignatura **Programación de Móviles** (PMDM) del curso `<rellenar>`.
Grupo `<rellenar>`.
Modelo `<rellenar>`

## Descripción de la app
Eres el lotero del barrio. El jugador escribe el número y la serie de su cupón, pulsa **Comprobar cupón** y la app le enseña el cupón premiado del sorteo y le dice si le ha tocado algo y cuánto. Toda la app es **una sola pantalla**.

## Rúbrica de evaluación — Mi Lotero Kotlin

La nota se obtiene por **niveles de cumplimiento acumulativos**. Hay que **completar un nivel entero para que cuente el siguiente**: los puntos de Avanzado solo suman si el Básico está completo, y los de Excelente solo si el Avanzado está completo.

| Nivel     | Nota máxima | Se evalúa si...           |
|-----------|-------------|---------------------------|
| Básico    | 5           | Siempre                   |
| Avanzado  | 8           | Básico completo           |
| Excelente | 10          | Básico y Avanzado completos |

---

### Estructura de la pantalla (de arriba abajo)

```
┌─────────────────────────────────────────┐
│            Mi Lotero Kotlin             │  ← TopAppBar
├─────────────────────────────────────────┤
│                                         │
│              Cupón ganador              │  ← Título
│                                         │
│            00256   Serie: 01            │  ← Cupón ganador
│                                         │
│  ┌──────────┐  ¡Felicidades! Has ganado │
│  │  imagen  │  500000 €. ¡Muchas        │  ← Banner de premio
│  └──────────┘  gracias por jugar!       │     (imagen + mensaje)
│                                         │
│  ┌ Número ───────────┐  ┌ Serie ─────┐  │
│  │ 256               │  │ 1          │  │  ← Comprobar cupón
│  └───────────────────┘  └────────────┘  │     (dos campos de texto)
│    3 / 5                  1 / 2         │
│                                         │
│    ┌─────────────────┐  ┌─────────┐     │
│    │ Comprobar cupón │  │ Limpiar │     │  ← Botones
│    └─────────────────┘  └─────────┘     │
└─────────────────────────────────────────┘
```


![alt text](image.png)

### Zonas

El cupón premiado del sorteo está en `SorteoRepository.cuponPremiado` (número `00256`, serie `01`).

1. **TopAppBar**: barra superior con el título **"Mi Lotero Kotlin"** centrado.
2. **Título**: texto grande (`headlineLarge`) **"Cupón ganador"**.
3. **Cupón ganador**: el número premiado con 5 cifras, grande y en negrita, y a su lado **"Serie: XX"** con la serie a 2 cifras.
   - Antes de comprobar (y después de pulsar Limpiar), en lugar del cupón ganador y del banner se ve el texto **"Pulse para comprobar su premio"**.
4. **Banner de premio**: una imagen a la izquierda y un mensaje a la derecha.
   - Con premio: imagen `premio_dinero` y el texto **"¡Felicidades! Has ganado X €. ¡Muchas gracias por jugar!"**, donde X es el importe del premio.
   - Sin premio: imagen `sin_premio_monedero` y el texto **"Vaya, esta vez no ha habido suerte. ¡Muchas gracias por jugar!"**
5. **Comprobar cupón**: dos campos de texto en la misma fila, **"Número"** (más ancho) y **"Serie"**.
   - Solo admiten dígitos: como máximo 5 en el número y 2 en la serie.
   - Al pulsarlos sale el teclado numérico.
   - Debajo de cada uno se ve un contador **"n / máx"** (p. ej. `3 / 5`).
6. **Botones**: dos botones en la misma fila, centrados.
   - **Comprobar cupón**: compara lo escrito con el cupón premiado, muestra el resultado y el Toast **"Cupón comprobado"**. Está deshabilitado mientras falte el número o la serie.
   - **Limpiar**: muestra el Toast **"Formulario limpiado"** y deja la pantalla como al principio (campos vacíos y sin resultado).

Todo el contenido tiene un **margen de 8 dp** respecto a los bordes de la pantalla.

### Tabla de premios

Lo que escribe el jugador se compara con el cupón premiado rellenando con ceros a la izquierda (`256` equivale a `00256`, `1` a `01`).

- **Básico y Avanzado**: solo hay un premio. Si coinciden **el número y la serie**, el premio es de **500000 €**. Si no coinciden los dos, no hay premio.
- **Excelente**: se aplica la tabla completa. Se comprueba de **mayor a menor** premio y se da **solo el primero** que encaje:

| Aciertos (comparando con el cupón premiado) | Premio    |
|---------------------------------------------|-----------|
| Las 5 cifras **y** la serie                 | 500000 €  |
| Las 5 cifras (serie distinta)               | 35000 €   |
| Las 4 últimas cifras                        | 250 €     |
| Las 3 últimas cifras                        | 25 €      |
| Las 2 últimas cifras                        | 6 €       |
| La última cifra (reintegro)                 | 2 €       |
| Ninguna                                     | 0 €       |

### Ejemplo de uso

Versión Excelente. El cupón premiado es el `00256`, serie `01`.

| Acción del jugador | Cupón ganador | Imagen | Mensaje del banner |
|---|---|---|---|
| Abre la app | *(oculto: "Pulse para comprobar su premio")* | — | — |
| Escribe número `256` | *(oculto)* | — | — *(Comprobar sigue deshabilitado)* |
| Escribe serie `1` y pulsa **Comprobar cupón** | 00256 Serie: 01 | Bolsa de dinero | ¡Felicidades! Has ganado 500000 €... (+ Toast) |
| Cambia la serie a `7` y pulsa **Comprobar cupón** | 00256 Serie: 01 | Bolsa de dinero | ¡Felicidades! Has ganado 35000 €... (+ Toast) |
| Cambia el número a `99956` y pulsa **Comprobar cupón** | 00256 Serie: 01 | Bolsa de dinero | ¡Felicidades! Has ganado 6 €... (+ Toast) |
| Cambia el número a `12341` y pulsa **Comprobar cupón** | 00256 Serie: 01 | Monedero vacío | Vaya, esta vez no ha habido suerte... (+ Toast) |
| Pulsa **Limpiar** | *(oculto: "Pulse para comprobar su premio")* | — | — *(campos vacíos, + Toast)* |

> En Avanzado, la segunda y la tercera comprobación darían **sin premio**, porque solo cuenta el acierto de número y serie.

### Capturas de referencia

Arriba tienes una captura de la app en funcionamiento, con un cupón ya comprobado.

> La captura muestra la versión **Excelente** (nivel máximo). En el nivel Básico basta con que todos los elementos estén en pantalla. Consulta cada nivel para saber qué tiene que ser dinámico.

---

## Requisitos críticos (sin ellos no se aprueba)

Si falta alguno, el nivel Básico **no se da por superado** y la nota máxima es **4**, aunque la app funcione en función de lo cerca que esté de la versión final.

- [ ] **Componentes separados en `ui.components`**: como mínimo cuatro ficheros o composables independientes. Se te proporcionan vacíos. Si quieres puedes fusionar alguno pero al menos que hayan 3:
  1. Cupón ganador (`CuponGanador`)
  2. Banner de premio (`BannerPremio`)
  3. Campos del cupón (`CuponComprobar`)
  4. Botones (`FilaBotones`)
- [ ] **Nada de UI en `MainActivity`**: la Activity solo llama a la app/pantalla. La composición de la pantalla va en `ui.screens` (`MainScreen`).
- [ ] **Padding global de 8 dp** aplicado al contenido de la pantalla.
- [ ] **El proyecto compila y arranca** sin errores.

---

## Nivel Básico (hasta 5 puntos)

UI completa con todos los componentes y estado mínimo.

| # | Criterio | Puntos |
|---|----------|--------|
| B1 | **Título y cupón ganador** visibles: número y serie leídos de `SorteoRepository` y formateados (`00256`, `Serie: 01`). Vale que se vean siempre. | 0,75 |
| B2 | **Banner de premio** visible: imagen + mensaje (imagen y texto fijos valen en este nivel). | 0,75 |
| B3 | **Campos del cupón**: dos campos de texto con su etiqueta, "Número" y "Serie". | 1 |
| B4 | **Botones** "Comprobar cupón" y "Limpiar" visibles. | 0,5 |
| B5 | **Estado de los campos**: lo que escribe el jugador se queda escrito en cada campo (el estado vive en la pantalla). | 1 |
| B6 | **Comprobación**: al pulsar "Comprobar cupón" se compara el número **y** la serie con el cupón premiado y se ve el resultado (basta con que quede claro si hay premio o no). | 1 |
|   | **Total** | **5** |

---

## Nivel Avanzado (hasta 8 puntos, +3)

Solo cuenta si el Básico está completo o muy cerca de estarlo.

| # | Criterio | Puntos |
|---|----------|--------|
| A1 | **TopAppBar** con título, dentro de un `Scaffold`, y el `innerPadding` se respeta. | 0,5 |
| A2 | **Toasts** en ambos botones, cada uno con su mensaje. | 0,75 |
| A3 | **Validación de los campos**: solo dígitos, máximo 5 cifras en el número y 2 en la serie, teclado numérico y contador "n / máx" debajo de cada campo. | 0,75 |
| A4 | **Banner dinámico**: la imagen y el mensaje cambian según haya premio o no, y el mensaje muestra el importe (500000 €). | 1 |
|    | **Total** | **3** |

---

## Nivel Excelente (hasta 10 puntos, +2)

Solo cuenta si el Básico y el Avanzado están completos.

| # | Criterio | Puntos |
|---|----------|--------|
| E1 | **Resultado oculto hasta comprobar**: antes de pulsar "Comprobar cupón" no se ven ni el cupón ganador ni el banner; en su lugar aparece "Pulse para comprobar su premio". | 0,5 |
| E2 | **Formulario controlado**: "Limpiar" deja la pantalla como al principio (campos vacíos y resultado oculto, además del Toast), y "Comprobar cupón" está deshabilitado mientras falte el número o la serie. | 0,5 |
| E3 | **Tabla de premios completa**: se comprueba de mayor a menor premio (número y serie, 5 cifras, 4, 3, 2 y última cifra) y se da solo el primero que encaje. | 1 |
|    | **Total** | **2** |

---

## Ajuste por prácticas de código

Se aplica sobre la nota del nivel alcanzado. La nota final nunca pasa de **10** ni baja de **0**.

### Buenas prácticas (suman hasta +1 punto)

- [ ] Textos en `strings.xml`, no hardcodeados (incluido el título del TopAppBar, las etiquetas de los campos y los mensajes de los Toast). Te doy los textos ya picados, pero puedes añadir los tuyos si prefieres.
- [ ] **State hoisting**: el estado vive en `MainScreen`; los componentes de `ui.components` lo reciben por parámetro y avisan con lambdas (`onNumeroChange`, `onComprobarClick`...).
- [ ] Cada componente acepta un `modifier: Modifier = Modifier`.
- [ ] Hay `@Preview` de los componentes.
- [ ] Se espacian los componentes para que no se solapen y quede estético.
- [ ] Nombres claros y coherentes en composables, parámetros y variables.

### Malas prácticas (restan hasta −1 punto)

- [ ] Estado (`remember`/`mutableStateOf`) metido dentro de los componentes de `ui.components` en vez de elevarlo.
- [ ] Cupón premiado copiado a mano en la UI en vez de leerlo de `SorteoRepository`.
- [ ] Valores mágicos repetidos (paddings, tamaños, longitudes máximas, textos) sin ningún criterio coherente.
- [ ] `stringResource` u otras llamadas `@Composable` dentro de lambdas `onClick` (no compila o fuerza apaños).
- [ ] Código muerto sin sentido, o muchos imports sin usar.
