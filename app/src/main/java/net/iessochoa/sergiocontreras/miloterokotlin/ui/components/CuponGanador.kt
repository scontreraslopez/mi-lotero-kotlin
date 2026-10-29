package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CuponGanador(
    numero: String,
    serie: String,
    mostrar: Boolean,
    modifier: Modifier = Modifier
) {
    if(mostrar) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = numero.padStart(5, '0'),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("Serie: ${serie.padStart(2, '0')}")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CuponGanadorPreview() = CuponGanador("12345", "10", true, Modifier.fillMaxWidth())
