package ir.hfathi.cryptotest.network.client

import io.ktor.client.call.body
import io.ktor.client.request.get
import ir.hfathi.cryptotest.CryptoApi
import ir.hfathi.cryptotest.CryptoApi.Companion.ENDPOINT_URL
import ir.hfathi.cryptotest.CryptoApi.Companion.GET_COINS_ENDPOINTS
import ir.hfathi.cryptotest.network.model.CryptoApiModel


class CryptoApiClient(private val cryptoApi: CryptoApi) :ICryptoApiClient {

    override suspend fun getCoinsList(): List<CryptoApiModel> =
        cryptoApi.client.get(urlString = ENDPOINT_URL + GET_COINS_ENDPOINTS).body()

}