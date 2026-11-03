package net.iessochoa.sergiocontreras.miloterokotlin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.miloterokotlin.R
import net.iessochoa.sergiocontreras.miloterokotlin.data.SorteoRepository
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.BannerPremio
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.CuponComprobar
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.CuponGanador
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.FilaBotones
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.AlturaHuecoPremio
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.EspacioMedio
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.EspacioPequeno
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val cuponGanador = SorteoRepository.cuponPremiado
    val numeroGanador = cuponGanador.numeroFormateado
    val serieGanador = cuponGanador.serieFormateada

    var premioRevelado by remember { mutableStateOf(false) }
    var numeroJugado by remember { mutableStateOf("") }
    var serieJugada by remember { mutableStateOf("") }
    var premio by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier.padding(EspacioPequeno),
        verticalArrangement = Arrangement.spacedBy(EspacioMedio, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.titulo_cupon_ganador),
            style = MaterialTheme.typography.headlineLarge
        )

        if (premioRevelado) {
            CuponGanador(
                numero = numeroGanador,
                serie = serieGanador
            )
            BannerPremio(premio = premio)
        } else {
            Text(stringResource(R.string.instruccion_comprobar))
            Spacer(modifier = Modifier.height(AlturaHuecoPremio))
        }

        CuponComprobar(
            numero = numeroJugado,
            serie = serieJugada,
            onNumeroChange = { numeroJugado = it },
            onSerieChange = { serieJugada = it },
            modifier = Modifier.fillMaxWidth()
        )

        FilaBotones(
            onComprobarClick = {
                premioRevelado = true
                premio = calcularPremio(
                    numeroJugado = formatNumero(numeroJugado),
                    serieJugada = formatSerie(serieJugada),
                    numeroGanador = numeroGanador,
                    serieGanador = serieGanador
                )
            },
            onLimpiarClick = {
                premioRevelado = false
                premio = 0
                numeroJugado = ""
                serieJugada = ""
            },
            comprobarHabilitado = numeroJugado.isNotEmpty() && serieJugada.isNotEmpty()
        )
    }
}

// Nivel básico: premio solo por coincidencia del número (5 cifras, o 5 cifras y serie)
// Nivel completo: tabla de premios por terminaciones
fun calcularPremio(
    numeroJugado: String,
    serieJugada: String,
    numeroGanador: String,
    serieGanador: String
): Int = when {
    numeroJugado == numeroGanador && serieJugada == serieGanador -> 500_000
    numeroJugado == numeroGanador -> 35_000
    numeroJugado.takeLast(4) == numeroGanador.takeLast(4) -> 250
    numeroJugado.takeLast(3) == numeroGanador.takeLast(3) -> 25
    numeroJugado.takeLast(2) == numeroGanador.takeLast(2) -> 6
    numeroJugado.takeLast(1) == numeroGanador.takeLast(1) -> 2
    else -> 0
}

fun formatNumero(numero: String): String = numero.padStart(5, '0')

fun formatSerie(serie: String): String = serie.padStart(2, '0')

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MiLoteroKotlinTheme {
        MainScreen(modifier = Modifier.fillMaxSize())
    }
}