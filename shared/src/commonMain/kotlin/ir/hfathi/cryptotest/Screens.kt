package ir.hfathi.cryptotest

sealed class Screens {

    object CryptoListScreen : Screens()

    data class CryptoDetails(val cryptoId: String) : Screens()
}