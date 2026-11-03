package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.miloterokotlin.R
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.EspacioPequeno
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme

private const val MAX_CARACTERES_NUMERO = 5
private const val MAX_CARACTERES_SERIE = 2 // Cupón diario: serie del 1 al 50

@Composable
fun CuponComprobar(
    numero: String,
    serie: String,
    onNumeroChange: (String) -> Unit,
    onSerieChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(EspacioPequeno),
        modifier = modifier
    ) {
        OutlinedTextField(
            value = numero,
            label = { Text(stringResource(R.string.etiqueta_numero)) },
            onValueChange = { nuevo ->
                if (nuevo.length <= MAX_CARACTERES_NUMERO && nuevo.all { it.isDigit() }) {
                    onNumeroChange(nuevo)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            supportingText = {
                Text(stringResource(R.string.contador_caracteres, numero.length, MAX_CARACTERES_NUMERO))
            },
            modifier = Modifier.weight(3f)
        )
        OutlinedTextField(
            value = serie,
            label = { Text(stringResource(R.string.etiqueta_serie)) },
            onValueChange = { nuevo ->
                if (nuevo.length <= MAX_CARACTERES_SERIE && nuevo.all { it.isDigit() }) {
                    onSerieChange(nuevo)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            supportingText = {
                Text(stringResource(R.string.contador_caracteres, serie.length, MAX_CARACTERES_SERIE))
            },
            modifier = Modifier.weight(2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CuponComprobarPreview() {
    MiLoteroKotlinTheme {
        CuponComprobar(
            numero = "12345",
            serie = "10",
            onNumeroChange = {},
            onSerieChange = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}