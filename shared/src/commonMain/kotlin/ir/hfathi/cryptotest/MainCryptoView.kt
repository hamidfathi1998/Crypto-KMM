package ir.hfathi.cryptotest

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ir.hfathi.cryptotest.ui.crypto_details.CryptoDetailsScreen
import ir.hfathi.cryptotest.ui.crypto_details.CryptoDetailsViewModel
import ir.hfathi.cryptotest.ui.crypto_list.CryptoListScreen

@Composable
fun MainCryptoView() {
    var screenState by remember { mutableStateOf<Screens>(Screens.CryptoListScreen) }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            when (val screen = screenState) {
                is Screens.CryptoListScreen ->
                    CryptoListScreen(
                        cryptoList = listOf(),
                        onItemClick = { screenState = Screens.CryptoDetails(cryptoId = it) }
                    )

                is Screens.CryptoDetails ->
                    CryptoDetailsScreen(
                        cryptoDetailsViewModel = CryptoDetailsViewModel(),
                        cryptoId = screen.cryptoId,
                        onBack = { screenState = Screens.CryptoListScreen }
                    )
            }
        }
}

