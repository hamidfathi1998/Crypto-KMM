package ir.hfathi.cryptotest.domain.usecase

import ir.hfathi.cryptotest.data.entitiy.CoinEntity
import ir.hfathi.cryptotest.domain.repository.IMarketRepository
import ir.hfathi.cryptotest.domain.Result

class GetCoinListUseCase(private val marketRepository: IMarketRepository) {

    suspend operator fun invoke(): Result<List<CoinEntity>> =
        marketRepository.getCoins()
}