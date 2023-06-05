package ir.hfathi.cryptotest.android.di

import ir.hfathi.cryptotest.ui.MainCryptoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainCryptoViewModel() }
}
