package net.iessochoa.sergiocontreras.miloterokotlin.data

import net.iessochoa.sergiocontreras.miloterokotlin.model.Cupon

/**
 * Fuente de datos del sorteo.
 *
 * Es un `object` (singleton): no hace falta crear instancias, se usa directamente
 * como `SorteoRepository.cuponPremiado`.
 *
 * > Pista: **no copies el número ganador en la UI** (nada de escribir `"00256"` a mano).
 * > Pídeselo al repositorio desde la pantalla. Si mañana cambia el sorteo, la UI no
 * > debería tener que tocarse. También te sirve para las `@Preview` de los componentes.
 *
 * ## Tabla de premios
 *
 * En los niveles Básico y Avanzado solo hay un premio: **número y serie coinciden →
 * 500000 €**. Si no coinciden los dos, no hay premio (0 €).
 *
 * En el nivel Excelente se aplica la tabla completa. Se comprueba de **mayor a menor**
 * premio y se da **solo el primero** que encaje:
 *
 * | Aciertos (comparando con el cupón premiado) | Premio    |
 * |---------------------------------------------|-----------|
 * | Las 5 cifras **y** la serie                 | 500000 €  |
 * | Las 5 cifras (serie distinta)               | 35000 €   |
 * | Las 4 últimas cifras                        | 250 €     |
 * | Las 3 últimas cifras                        | 25 €      |
 * | Las 2 últimas cifras                        | 6 €       |
 * | La última cifra (reintegro)                 | 2 €       |
 * | Ninguna                                     | 0 €       |
 *
 * > Pista: el orden importa. Un cupón que acierta las 5 cifras también acierta las 4
 * > últimas, las 3 últimas... Si lo compruebas de mayor a menor y te quedas con el primero
 * > que encaje, no hay ambigüedad. Un `when { ... }` sin argumento hace justo eso: evalúa
 * > las condiciones en orden y se queda con la primera que sea `true`. Otra opción es
 * > guardar la tabla en una lista de pares `(cifras, premio)` y usar `firstOrNull { ... }`.
 */
object SorteoRepository {

    /**
     * El cupón premiado en el sorteo. Se muestra como `00256` y serie `01`.
     */
    val cuponPremiado = Cupon(
        numero = 256,
        serie = 1
    )
}
