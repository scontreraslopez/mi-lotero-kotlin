package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.miloterokotlin.R
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.EspacioPequeno
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme

@Composable
fun FilaBotones(
    onComprobarClick: () -> Unit,
    onLimpiarClick: () -> Unit,
    modifier: Modifier = Modifier,
    comprobarHabilitado: Boolean = true
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(EspacioPequeno, Alignment.CenterHorizontally)
    ) {
        Button(
            onClick = onComprobarClick,
            enabled = comprobarHabilitado
        ) {
            Text(stringResource(R.string.boton_comprobar))
        }
        Button(onClick = onLimpiarClick) {
            Text(stringResource(R.string.boton_limpiar))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilaBotonesPreview() {
    MiLoteroKotlinTheme {
        FilaBotones(
            onComprobarClick = {},
            onLimpiarClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}