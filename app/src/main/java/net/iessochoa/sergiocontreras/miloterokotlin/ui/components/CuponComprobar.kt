package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
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
            onValueChange = { nuevo ->
                if (nuevo.length <= maxCaracteresNumero && nuevo.all { it.isDigit() }) {
                    onNumeroChange(nuevo)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            supportingText = { Text("${numero.length} / $maxCaracteresNumero") },
            modifier = Modifier.weight(3f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        //Spacer(modifier = modifier.width(8.dp))
        //Serie (del 1 al 50) cupón diario
        val maxCaracteresSerie = 2
        OutlinedTextField(
            value = serie,
            label = { Text("Serie") },
            onValueChange = { nuevo ->
                if (nuevo.length <= maxCaracteresSerie && nuevo.all { it.isDigit() }) {
                    onSerieChange(nuevo)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            supportingText = { Text("${serie.length} / $maxCaracteresSerie") },
            modifier = Modifier.weight(2f)
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
