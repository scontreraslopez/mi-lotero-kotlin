package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
    modifier: Modifier = Modifier,
    premio: Int,
    //@StringRes mensajePremioRes: Int,
    @DrawableRes imageRes: Int
) {

    // Vaya, esta vez no ha habido suerte. ¡Muchas gracias por jugar!
    // ¡Felicidades! Has ganado XX €. ¡Muchas gracias por jugar!

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Image(
            painterResource(id = imageRes),
            contentDescription = "Imagen premio",
            modifier = Modifier.weight(1f)
        )

        when {
            premio > 0 -> {
                Text(
                    text = stringResource(R.string.mensaje_premio, premio),
                    modifier = Modifier
                        .weight(2f)
                )
            }
            else -> {
                Text(
                    text = "Vaya, esta vez no ha habido suerte. ¡Muchas gracias por jugar!",
                    modifier = Modifier
                        .weight(2f)
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun BannerPremioPreview() = BannerPremio(
    imageRes = R.drawable.premio_dinero,
    premio = 15,
    //mensajePremioRes = TODO()
)