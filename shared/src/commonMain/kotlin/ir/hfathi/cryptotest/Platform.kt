package ir.hfathi.cryptotest

import androidx.compose.runtime.Composable

interface Platform {
    val name: String
}


expect fun getPlatform(): Platform