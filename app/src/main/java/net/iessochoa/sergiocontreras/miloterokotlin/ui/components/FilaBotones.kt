package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilaBotones(
    onComprobarClick: () -> Unit,
    onLimpiarClick: () -> Unit,
    modifier: Modifier = Modifier,
    comprobarHabilitado: Boolean = true
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround
    )
    {
        //Comprobar cupon
        Button(
            onClick = onComprobarClick,
            enabled = comprobarHabilitado
        ) {
            Text("Comprobar Cupon")
        }
        Spacer(modifier = Modifier.width(8.dp))
        //Limpiar
        Button(
            onClick = onLimpiarClick
        ) {
            Text("Limpiar")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FilaBotonesPreview()  = FilaBotones({ }, { }, modifier = Modifier.fillMaxWidth(), )