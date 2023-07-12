package ir.hfathi.cryptotest.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ir.hfathi.cryptotest.Action
import androidx.navigation.compose.rememberNavController
import ir.hfathi.cryptotest.CryptoApplicationTheme
import org.koin.androidx.compose.getViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoApp()
        }
    }
}

@Composable
internal fun CryptoApp(mainViewModel: MainViewModel = getViewModel()) {
    val navController = rememberNavController()
    val action = remember(navController) { Action(navController) }

    CryptoApplicationTheme(darkTheme = false) {
        CryptoNavHost(
            navController = navController,
            action = action
        )
    }
}