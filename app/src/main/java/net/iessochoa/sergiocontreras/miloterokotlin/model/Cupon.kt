package net.iessochoa.sergiocontreras.miloterokotlin.model

/**
 * Un cupón de lotería: un número de 5 cifras y una serie.
 *
 * Al ser una `data class`, dos cupones con el mismo [numero] y la misma [serie] se
 * consideran **iguales** (`==`). Si construyes un `Cupon` con lo que ha escrito el
 * jugador, puedes compararlo directamente con el premiado.
 *
 * > Pista: lo que escribe el jugador en los campos es un `String` ("256", "1"), pero aquí
 * > los valores son `Int`. Tienes dos caminos para comparar:
 * >  - Pasar el texto a número con `toIntOrNull()` y comparar `Int` con `==`.
 * >  - Rellenar el texto con ceros a la izquierda (`padStart(5, '0')`) y compararlo con
 * >    [numeroFormateado] / [serieFormateada]. Así `"256"` y `"00256"` valen lo mismo.
 *
 * > Pista (tabla de premios, nivel Excelente): para las terminaciones trabaja con el
 * > número como `String` de 5 cifras. `takeLast(n)` te da las `n` últimas cifras y
 * > `endsWith(...)` te dice si un texto acaba en otro.
 *
 * @property numero Número del cupón, de 0 a 99999.
 * @property serie Serie del cupón, de 1 a 50.
 */
data class Cupon(
    val numero: Int,
    val serie: Int
) {
    /**
     * Número con 5 cifras, rellenado con ceros a la izquierda. P. ej. `256` → `"00256"`.
     *
     * Es el formato con el que se muestra el cupón ganador en pantalla.
     */
    val numeroFormateado: String
        get() = numero.toString().padStart(5, '0')

    /**
     * Serie con 2 cifras, rellenada con ceros a la izquierda. P. ej. `1` → `"01"`.
     */
    val serieFormateada: String
        get() = serie.toString().padStart(2, '0')
}
