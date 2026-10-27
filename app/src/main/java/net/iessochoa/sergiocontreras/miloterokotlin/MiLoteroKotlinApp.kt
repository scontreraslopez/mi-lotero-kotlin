package net.iessochoa.sergiocontreras.miloterokotlin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.iessochoa.sergiocontreras.miloterokotlin.ui.screens.MainScreen
import net.iessochoa.sergiocontreras.miloterokotlin.ui.theme.MiLoteroKotlinTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiLoteroKotlinApp() {
    MiLoteroKotlinTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { CenterAlignedTopAppBar(title = { Text("Mi Lotero Kotlin") }) }
        ) { innerPadding ->
            MainScreen(modifier = Modifier.fillMaxSize()
                .padding(innerPadding))
        }
    }
}