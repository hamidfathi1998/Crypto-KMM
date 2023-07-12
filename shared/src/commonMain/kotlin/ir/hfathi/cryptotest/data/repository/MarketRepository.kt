package ir.hfathi.cryptotest.data.repository

import ir.hfathi.cryptotest.data.entitiy.CoinEntity
import ir.hfathi.cryptotest.data.remotedatasource.IMarketRemoteDataSource
import ir.hfathi.cryptotest.domain.repository.IMarketRepository
import ir.hfathi.cryptotest.domain.Result

class MarketRepository(private val marketRemoteDataSource: IMarketRemoteDataSource) : IMarketRepository {
    override suspend fun getCoins(): Result<List<CoinEntity>> =
        marketRemoteDataSource.getCoins()

}