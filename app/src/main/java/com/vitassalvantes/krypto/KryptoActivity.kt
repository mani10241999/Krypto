package com.vitassalvantes.krypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.vitassalvantes.krypto.navigation.KryptoBottomAppBar
import com.vitassalvantes.krypto.navigation.KryptoFloatingActionButton
import com.vitassalvantes.krypto.navigation.KryptoNavHost
import com.vitassalvantes.krypto.ui.theme.KryptoTheme

/**
 * The entry point to the program.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KryptoApp()
        }
    }
}

/**
 * Managing the main content in the app, that consists of a Scaffold with [KryptoBottomAppBar]
 * and [KryptoNavHost] that controls the display of screens.
 */
@Composable
fun KryptoApp() {
    KryptoTheme {
        /**
         * The central API for the Navigation component.
         * It is stateful and keeps track of the back stack of composables that make up the screens
         * in this app and the state of each screen.
         */
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { KryptoBottomAppBar(navController) },
            floatingActionButton = { KryptoFloatingActionButton() },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true
        ) { innerPadding ->
            KryptoNavHost(navController = navController, innerPadding = innerPadding)
        }
    }
}
