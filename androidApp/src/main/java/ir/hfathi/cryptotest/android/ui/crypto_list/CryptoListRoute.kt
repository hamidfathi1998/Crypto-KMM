package ir.hfathi.cryptotest.android.ui.crypto_list

import androidx.compose.runtime.Composable
import ir.hfathi.cryptotest.ui.crypto_list.CryptoListScreen
import ir.hfathi.cryptotest.ui.crypto_list.CryptoListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
internal fun CryptoListRoute(
    cryptoListViewModel: CryptoListViewModel  = getViewModel()
) {
    CryptoListScreen(
        cryptoList = cryptoListViewModel.getCoinsData(),
        onItemClick = {

        }
    )
}