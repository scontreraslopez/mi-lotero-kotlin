package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.miloterokotlin.R

@Composable
fun BannerPremio(
    premio: Int,
    modifier: Modifier = Modifier
) {
    val hayPremio = premio > 0

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(
                id = if (hayPremio) R.drawable.premio_dinero else R.drawable.sin_premio_monedero
            ),
            contentDescription = if (hayPremio) "Imagen premio" else "Imagen sin premio",
            modifier = Modifier.weight(1f)
        )

        Text(
            text = if (hayPremio) {
                stringResource(R.string.mensaje_premio, premio)
            } else {
                "Vaya, esta vez no ha habido suerte. ¡Muchas gracias por jugar!"
            },
            modifier = Modifier.weight(2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BannerPremioPreview() = BannerPremio(premio = 500_000)

@Preview(showBackground = true)
@Composable
fun BannerSinPremioPreview() = BannerPremio(premio = 0)
