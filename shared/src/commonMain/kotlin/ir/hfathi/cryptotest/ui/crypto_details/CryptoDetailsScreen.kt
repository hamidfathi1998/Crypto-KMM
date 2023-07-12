package ir.hfathi.cryptotest.ui.crypto_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CryptoDetailsScreen(
    cryptoDetailsViewModel: CryptoDetailsViewModel,
    cryptoId: String,
    onBack: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = cryptoId + cryptoDetailsViewModel.getStr())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBack) {
            Text(text = "Back")
        }
    }
}