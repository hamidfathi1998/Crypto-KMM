package ir.hfathi.cryptotest.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val useCaseModule = module {}

private val repositoryModule = module {}

private val apiModule = module {}

private val utilityModule = module {}

private val sharedModules =
    listOf(useCaseModule, repositoryModule, apiModule, utilityModule)

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    modules(sharedModules)
    appDeclaration()
}

fun initKoin() = initKoin { }