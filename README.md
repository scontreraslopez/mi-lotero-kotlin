# Mi Lotero Kotlin

Parcial 1 de **Programación Multimedia y Dispositivos Móviles** (PMDM), curso 2026-2027, grupo 2K, **Modelo B**.

Una app de lotería para el instituto. El jugador escribe el número y la serie de su cupón, pulsa **Comprobar cupón** y la app le enseña el cupón premiado del sorteo y le dice si le ha tocado algo y cuánto. Es una app de **una sola pantalla** hecha con Jetpack Compose y Material 3.

## Estructura del repositorio

Este repositorio contiene el examen del Parcial 1 (Modelo B) de PMDM.

- `main` → solución de referencia
- `starter` → código inicial que recibió el alumnado, con el enunciado (`ENUNCIADO.md`) y la captura de referencia

Para intentarlo por tu cuenta: `git checkout starter`

> El enunciado completo, con la rúbrica y la tabla de premios, solo está en la rama `starter`. Léelo antes de mirar la solución.

## Qué se evalúa

El examen no pide "una app que funcione" sin más: pide una app **bien troceada**. Lo que se mira es si sabes separar la UI en componentes, elevar el estado y trabajar con campos de texto controlados.

### Requisitos críticos

Si falta alguno, la nota máxima es un 4 aunque la app funcione:

- Componentes separados en `ui.components` (mínimo tres de los cuatro: `CuponGanador`, `BannerPremio`, `CuponComprobar`, `FilaBotones`).
- Nada de UI en `MainActivity`; la pantalla se compone en `ui.screens.MainScreen`.
- Padding global de 8 dp.
- El proyecto compila y arranca.

### Niveles acumulativos

La nota va por niveles, y **un nivel solo cuenta si el anterior está completo**:

| Nivel     | Nota máx. | Qué añade |
|-----------|-----------|-----------|
| Básico    | 5  | Todos los componentes en pantalla, campos que guardan lo escrito y comprobación exacta de número y serie |
| Avanzado  | 8  | `Scaffold` + TopAppBar, Toasts, validación de los campos (solo dígitos, longitud máxima, teclado numérico, contador) y banner dinámico |
| Excelente | 10 | Resultado oculto hasta comprobar, Limpiar que resetea y Comprobar deshabilitado con campos vacíos, tabla de premios completa |

Sobre esa nota se aplica un ajuste de ±1 punto por buenas y malas prácticas: textos en `strings.xml`, state hoisting, `modifier` en cada componente, `@Preview`, nombres claros… frente a estado dentro de los componentes, cupón premiado copiado a mano en la UI, valores mágicos o código muerto.

## El código de partida (`starter`)

La rama `starter` no está vacía. Trae:

- El modelo (`Cupon`), con `numeroFormateado` y `serieFormateada` ya hechos, y el repositorio (`SorteoRepository`) con el cupón premiado (`00256`, serie `01`).
- `MainActivity` y `MiLoteroKotlinApp` ya conectados.
- Los ficheros de los componentes y de `MainScreen` con **comentarios guía**: qué se pide en cada nivel, una sugerencia de pasos y pistas para los puntos donde se suele atascar la gente (los Toast, la validación de los campos, cómo comparar un `String` con un `Int`…).
- Todos los textos ya metidos en `strings.xml` y las imágenes `sin_premio_monedero` y `premio_dinero`.

La idea es que el examen mida cómo se estructura y se conecta la UI, no cuánto tiempo se tarda en escribir código repetitivo.

## Claves de la solución

- **Estado en `MainScreen`.** Se guardan el texto del número y el de la serie, el premio de la última comprobación y si ya se ha pulsado "Comprobar cupón" (`premioRevelado`). El premio se calcula al pulsar el botón y no en cada recomposición: si el jugador edita los campos después, el resultado no cambia hasta que vuelva a comprobar. Lo que sí se deriva es si el botón está habilitado (`numeroJugado.isNotEmpty() && serieJugada.isNotEmpty()`).
- **State hoisting.** Los componentes de `ui.components` no tienen estado propio: reciben valores por parámetro y avisan con lambdas (`onNumeroChange`, `onSerieChange`, `onComprobarClick`, `onLimpiarClick`).
- **Validación en el propio `onValueChange`.** `CuponComprobar` solo reenvía el texto nuevo si son todo dígitos y no pasa de la longitud máxima; si no, lo ignora y el campo se queda como estaba. Las longitudes máximas son constantes (`MAX_CARACTERES_NUMERO`, `MAX_CARACTERES_SERIE`) que se usan tanto para validar como para el contador `supportingText`. Teclado numérico con `KeyboardOptions(keyboardType = KeyboardType.Number)`.
- **Tabla de premios con un `when`.** Lo escrito se rellena con ceros (`padStart`) y se compara con el cupón ya formateado. El `when` va de mayor a menor premio y se queda con la primera rama que encaja; las terminaciones se comprueban con `takeLast(n)`.
- **Toasts y `stringResource`.** `stringResource` es `@Composable` y no se puede llamar dentro de un `onClick`, así que los mensajes se leen antes, fuera de la lambda, y se guardan en una `val`.
- **Hueco reservado.** Mientras el resultado está oculto se pinta "Pulse para comprobar su premio" y un `Spacer` de altura fija, para que los campos y los botones no salten de sitio al revelar el premio.
- **Sin valores mágicos.** Los espaciados viven en `ui/theme/Dimens.kt` (`EspacioPequeno` = 8 dp, `EspacioMedio` = 16 dp, `AlturaHuecoPremio`).
- **`Scaffold` en la app.** `MiLoteroKotlinApp` monta el tema, el `Scaffold` y la `CenterAlignedTopAppBar`, y le pasa a `MainScreen` el `innerPadding`; los 8 dp de margen los aplica `MainScreen` sobre su `Column`.

## Estructura del código

```
app/src/main/java/net/iessochoa/sergiocontreras/miloterokotlin/
├── MainActivity.kt              # Solo llama a MiLoteroKotlinApp()
├── MiLoteroKotlinApp.kt         # Tema + Scaffold + TopAppBar
├── data/SorteoRepository.kt     # Cupón premiado del sorteo
├── model/Cupon.kt               # numero + serie, con sus versiones formateadas
└── ui/
    ├── screens/MainScreen.kt    # Estado, cálculo del premio y composición de la pantalla
    ├── components/
    │   ├── CuponGanador.kt      # "00256   Serie: 01"
    │   ├── BannerPremio.kt      # Imagen + "¡Felicidades! Has ganado X €..." / "Vaya..."
    │   ├── CuponComprobar.kt    # Campos Número y Serie con validación y contador
    │   └── FilaBotones.kt       # Comprobar cupón / Limpiar
    └── theme/Dimens.kt          # Espaciados comunes
```
