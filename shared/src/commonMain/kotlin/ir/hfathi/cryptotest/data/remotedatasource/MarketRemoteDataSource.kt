package ir.hfathi.cryptotest.data.remotedatasource

import ir.hfathi.cryptotest.data.entitiy.CoinEntity
import ir.hfathi.cryptotest.network.client.ICryptoApiClient
import ir.hfathi.cryptotest.network.mapper.asCoinEntityList
import ir.hfathi.cryptotest.utils.safeApiCall
import ir.hfathi.cryptotest.domain.Result

class MarketRemoteDataSource(private val cryptoApiClient: ICryptoApiClient) :
    IMarketRemoteDataSource {

    override suspend fun getCoins(): Result<List<CoinEntity>> =
        safeApiCall {
            cryptoApiClient.getCoinsList()
        }.map { it.asCoinEntityList() }
}