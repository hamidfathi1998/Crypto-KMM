package ir.hfathi.cryptotest.domain.repository

import ir.hfathi.cryptotest.data.entitiy.CoinEntity
import ir.hfathi.cryptotest.domain.Result

interface IMarketRepository {

    suspend fun getCoins(): Result<List<CoinEntity>>
}