package ir.hfathi.cryptotest.android

import android.app.Application
import ir.hfathi.cryptotest.android.di.viewModelModule
import ir.hfathi.cryptotest.di.initKoin
import org.koin.android.ext.koin.androidContext


class CryptoTestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@CryptoTestApp)
            modules(viewModelModule)
        }
    }
}
