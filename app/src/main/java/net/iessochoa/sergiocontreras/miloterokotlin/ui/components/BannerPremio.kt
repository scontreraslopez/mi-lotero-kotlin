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
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme

@Composable
fun BannerPremio(
    premio: Int,
    modifier: Modifier = Modifier
) {
    val hayPremio = premio > 0

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                id = if (hayPremio) R.drawable.premio_dinero else R.drawable.sin_premio_monedero
            ),
            contentDescription = stringResource(
                if (hayPremio) R.string.descripcion_imagen_premio else R.string.descripcion_imagen_sin_premio
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = if (hayPremio) {
                stringResource(R.string.mensaje_premio, premio)
            } else {
                stringResource(R.string.mensaje_sin_premio)
            },
            modifier = Modifier.weight(2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BannerPremioPreview() {
    MiLoteroKotlinTheme {
        BannerPremio(premio = 500_000)
    }
}

@Preview(showBackground = true)
@Composable
fun BannerSinPremioPreview() {
    MiLoteroKotlinTheme {
        BannerPremio(premio = 0)
    }
}