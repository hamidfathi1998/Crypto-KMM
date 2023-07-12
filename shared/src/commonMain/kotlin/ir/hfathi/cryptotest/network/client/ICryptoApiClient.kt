package ir.hfathi.cryptotest.network.client

import ir.hfathi.cryptotest.network.model.CryptoApiModel

interface ICryptoApiClient {

    suspend fun getCoinsList(): List<CryptoApiModel>
}