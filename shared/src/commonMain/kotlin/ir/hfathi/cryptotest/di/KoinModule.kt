package ir.hfathi.cryptotest.di

import ir.hfathi.cryptotest.data.remotedatasource.IMarketRemoteDataSource
import ir.hfathi.cryptotest.domain.repository.IMarketRepository
import ir.hfathi.cryptotest.network.client.ICryptoApiClient
import ir.hfathi.cryptotest.ui.crypto_list.CryptoListViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ir.hfathi.cryptotest.domain.usecase.GetCoinListUseCase
import ir.hfathi.cryptotest.data.repository.MarketRepository
import org.koin.dsl.bind
import ir.hfathi.cryptotest.CryptoApi
import ir.hfathi.cryptotest.network.client.CryptoApiClient
import ir.hfathi.cryptotest.data.remotedatasource.MarketRemoteDataSource

internal val useCaseModule = module {
    singleOf(::GetCoinListUseCase)
}

internal val repositoryModule = module {
    singleOf(::MarketRepository) bind IMarketRepository::class
}

internal val apiModule = module {
    singleOf(::CryptoApi)
    singleOf(::CryptoApiClient) bind ICryptoApiClient::class
}

internal val remoteDataSourceModule = module {
    singleOf(::MarketRemoteDataSource) bind IMarketRemoteDataSource::class
}

internal val viewModelModule = module {
    factoryOf(::CryptoListViewModel)
}

internal fun startDI(appDeclaration: KoinAppDeclaration) = startKoin {
    modules(
        useCaseModule +
                remoteDataSourceModule +
                repositoryModule +
                apiModule +
                viewModelModule
    )
    appDeclaration()
}

fun startAppDI(appDeclaration: KoinAppDeclaration = {}) = startDI {
        modules(viewModelModule)
        appDeclaration()
    }
