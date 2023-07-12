package ir.hfathi.cryptotest.ui.crypto_list

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.androidx.compose.getViewModel

@Composable
internal fun CryptoListRoute(
    navigateBack: () -> Unit,
    cryptoListViewModel: CryptoListViewModel = getViewModel()
) {
    CryptoListScreen(
        cryptoList = cryptoListViewModel.getCoinsData(),
        onItemClick = {
            Log.e("hamid", "CryptoListRoute: ", )
        }
    )
}