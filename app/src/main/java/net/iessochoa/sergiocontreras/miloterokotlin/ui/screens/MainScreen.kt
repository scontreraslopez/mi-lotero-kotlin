package net.iessochoa.sergiocontreras.miloterokotlin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.miloterokotlin.R
import net.iessochoa.sergiocontreras.miloterokotlin.data.SorteoRepository
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.BannerPremio
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.CuponComprobar
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.CuponGanador
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.FilaBotones
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.Typography
import kotlin.math.pow

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val repository = SorteoRepository

    val cuponGanador = repository.cuponPremiado

    val numeroGanador = cuponGanador.numeroFormateado
    val serieGanador = cuponGanador.serieFormateada

    var premioRevelado by remember { mutableStateOf(false) }
    val (numeroJugado, onNumeroJugadoChange) = remember { mutableStateOf("") }
    val (serieJugada, onSerieJugadaChange) = remember { mutableStateOf("") }

    var premio = 0

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cupon Ganador",
            style = Typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        when(premioRevelado) {
            true -> {
                CuponGanador(
                    numero = numeroGanador,
                    serie = serieGanador,
                    mostrar = premioRevelado
                )

                BannerPremio(
                    imageRes = R.drawable.premio_dinero,
                    premio = premio,
                    //mensajePremioRes = R.string.mensaje_premio

                )

            }
            false -> {
                Text("Pulse para comprobar su premio")
                Spacer(modifier = Modifier.height(80.dp))

            }
        }
        Spacer(modifier = Modifier.height(16.dp))


        CuponComprobar(
            numero = numeroJugado,
            serie = serieJugada,
            onNumeroChange = onNumeroJugadoChange,
            onSerieChange = onSerieJugadaChange
        )
        Spacer(modifier = Modifier.height(16.dp))
        FilaBotones(
            onComprobarClick = {
                premioRevelado = true
                premio = calcularPremio(
                    numeroJugado = numeroJugado,
                    serieJugada = serieJugada,
                    numeroGanador = numeroGanador,
                    serieGanador = serieGanador
                )
            },
            onLimpiarClick = {
                premioRevelado = false
                premio = 0
            }
        )

        /*


        Text("TITULO")
        Text("Cupón ganador: 12345")
        Text("Enhorabuena: Has ganado 50€")
        Text("Comprueba tu Cupon")
        Text("Numero: 12345")
        Text("Serie: 11")
        Text("Comprobar")
        Text("Limpiar")
             */

    }
}

// Nivel básico: Premio solo  coincidencia número. Con premio para 5 cifras o 5 cifras y serie
// Nivel completo: Tabla de premios

fun calcularPremio(
    numeroJugado: String,
    serieJugada: String,
    numeroGanador: String,
    serieGanador: String
): Int {

    when {
        numeroJugado == numeroGanador &&
                serieJugada == serieGanador -> return 500_000
        numeroJugado == numeroGanador -> return 35_000
        numeroJugado.takeLast(4) == numeroGanador.takeLast(4) -> return 250
        numeroJugado.takeLast(3) == numeroGanador.takeLast(3) -> return 25
        numeroJugado.takeLast(2) == numeroGanador.takeLast(2) -> return 6
        numeroJugado.takeLast(1) == numeroGanador.takeLast(1) -> return 2
        else -> return 0
    }
}





@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MiLoteroKotlinTheme() {
        MainScreen(
            modifier = Modifier.fillMaxSize()
        )
    }
}

