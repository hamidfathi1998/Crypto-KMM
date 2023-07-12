package ir.hfathi.cryptotest.ui.crypto_list

import ir.hfathi.cryptotest.ViewModel
import ir.hfathi.cryptotest.data.entitiy.CoinEntity
import ir.hfathi.cryptotest.domain.usecase.GetCoinListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


open class CryptoListViewModel(private val getCoinListUseCase: GetCoinListUseCase) : ViewModel() {

    private val _listData = MutableStateFlow<List<CoinEntity>?>(null)
    val listData = _listData.asStateFlow()


    fun getCoinsData(): List<CoinEntity> {
        return listOf()
    }


}