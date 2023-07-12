package ir.hfathi.cryptotest.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.hfathi.cryptotest.android.ui.crypto_list.CryptoListRoute
import ir.hfathi.cryptotest.Action
import ir.hfathi.cryptotest.ui.crypto_list.CryptoListDestination

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun CryptoNavHost(
    navController: NavHostController,
    action: Action,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val navigateBackAction: () -> Unit = {
        keyboardController?.hide()
        action.navigateUp()
    }

    NavHost(
        navController = navController,
        startDestination = CryptoListDestination.route,
        modifier = modifier
    ) {
        composable(CryptoListDestination.route) {
            CryptoListRoute()
        }
    }
}