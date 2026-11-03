package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.miloterokotlin.R
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.EspacioMedio
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme

/**
 * Muestra el cupón ganador. Recibe número y serie ya formateados (ver [net.iessochoa.sergiocontreras.miloterokotlin.model.Cupon]).
 */
@Composable
fun CuponGanador(
    numero: String,
    serie: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(EspacioMedio, Alignment.CenterHorizontally)
    ) {
        Text(
            text = numero,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.alignByBaseline()
        )
        Text(
            text = stringResource(R.string.serie_formato, serie),
            modifier = Modifier.alignByBaseline()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CuponGanadorPreview() {
    MiLoteroKotlinTheme {
        CuponGanador(
            numero = "12345",
            serie = "10",
            modifier = Modifier.fillMaxWidth()
        )
    }
}