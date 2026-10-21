package net.iessochoa.sergiocontreras.miloterokotlin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.iessochoa.sergiocontreras.miloterokotlin.ui.screens.MainScreen
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme

@Composable
fun MiLoteroKotlinApp() {
    MiLoteroKotlinTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainScreen(modifier = Modifier.fillMaxSize()
                .padding(innerPadding))
        }
    }
}