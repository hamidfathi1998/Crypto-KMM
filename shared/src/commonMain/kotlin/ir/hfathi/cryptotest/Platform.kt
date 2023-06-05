package ir.hfathi.cryptotest

import androidx.compose.runtime.Composable
import ir.hfathi.cryptotest.ui.MainCryptoView

interface Platform {
    val name: String
}

@Composable
fun MainView() = MainCryptoView()

expect fun getPlatform(): Platform