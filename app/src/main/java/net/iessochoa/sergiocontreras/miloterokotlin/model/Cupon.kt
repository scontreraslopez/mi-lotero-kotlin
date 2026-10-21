package net.iessochoa.sergiocontreras.miloterokotlin.model

data class Cupon(
    val numero: Int,
    val serie: Int
) {
    val numeroFormateado: String
        get() = numero.toString().padStart(5, '0')

    val serieFormateada: String
        get() = serie.toString().padStart(3, '0')
}