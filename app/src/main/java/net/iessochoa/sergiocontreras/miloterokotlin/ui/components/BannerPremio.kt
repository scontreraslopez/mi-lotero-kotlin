package net.iessochoa.sergiocontreras.miloterokotlin.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.miloterokotlin.R

@Composable
fun BannerPremio(
    modifier: Modifier = Modifier,
    @DrawableRes imageInt: Int
) {

    // Vaya, esta vez no ha habido suerte. ¡Muchas gracias por jugar!

    // ¡Felicidades! Has ganado XX €. ¡Muchas gracias por jugar!

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = imageInt),
            contentDescription = "DD"
        )


        Text(
            "Vaya, esta vez no ha habido suerte. ¡Muchas gracias por jugar!"
            // Vaya, esta vez no ha habido suerte. ¡Muchas gracias por jugar!
            // ¡Felicidades! Has ganado XX €. ¡Muchas gracias por jugar!


        )



    }



}

@Preview(showBackground = true)
@Composable
fun BannerPremioPreview() = BannerPremio(imageInt = R.drawable.premio_dinero)