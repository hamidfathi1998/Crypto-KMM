package ir.hfathi.cryptotest.android

import android.app.Application
import ir.hfathi.cryptotest.di.startAppDI
import org.koin.android.ext.koin.androidContext
import ir.hfathi.cryptotest.android.di.viewModelModule

class CryptoTestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startAppDI {
            modules(viewModelModule)
            androidContext(this@CryptoTestApp)
        }
    }
}
