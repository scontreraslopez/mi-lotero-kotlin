package net.iessochoa.sergiocontreras.miloterokotlin.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.BannerPremio
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.CuponComprobar
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.CuponGanador
import net.iessochoa.sergiocontreras.miloterokotlin.ui.components.FilaBotones

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("TITULO")
        Text("Cupon Ganador: ")
        CuponGanador(
            numero = "12345",
            serie = "11",
            mostrar = true
        )
        BannerPremio(
        )
        CuponComprobar(
            numero = "12345",
            serie = "22",
            onNumeroChange = { } ,
            onSerieChange = { }
        )
        FilaBotones(
            onComprobarClick = {  },
            onLimpiarClick = { }
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




@Preview(showBackground = true)
@Composable
fun MainScreenPreview() = MainScreen(
    modifier = Modifier.fillMaxSize()
)
