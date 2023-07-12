package ir.hfathi.cryptotest.data.remotedatasource

import ir.hfathi.cryptotest.data.entitiy.CoinEntity
import ir.hfathi.cryptotest.domain.Result

interface IMarketRemoteDataSource {

    suspend fun getCoins(): Result<List<CoinEntity>>
}