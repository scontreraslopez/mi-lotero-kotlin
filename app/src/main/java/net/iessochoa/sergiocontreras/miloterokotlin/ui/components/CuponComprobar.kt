package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CuponComprobar(
    numero: String,
    serie: String,
    onNumeroChange: (String) -> Unit,
    onSerieChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        //Numero
        val maxCaracteresNumero = 5
        OutlinedTextField(
            value = numero,
            label = { Text("Número") },
            onValueChange = onNumeroChange,
            singleLine = true,
            supportingText = { Text("${numero.length} / $maxCaracteresNumero") },

        )
        Spacer(modifier = Modifier.width(8.dp))
        //Spacer(modifier = modifier.width(8.dp))
        //Serie (del 1 al 50) cupón diario
        val maxCaracteresSerie = 2
        OutlinedTextField(
            value = serie,
            label = { Text("Serie") },
            onValueChange = onSerieChange,
            singleLine = true,
            supportingText = { Text("${serie.length} / $maxCaracteresSerie") },
            )
    }
}

@Preview(showBackground = true)
@Composable
fun CuponComprobarPreview(
) {
    CuponComprobar(
        modifier = Modifier.fillMaxWidth(),
        numero = "12345",
        serie = "10",
        onNumeroChange = {},
        onSerieChange = {}
    )
}
