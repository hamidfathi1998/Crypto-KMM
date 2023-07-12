package ir.hfathi.cryptotest

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

actual abstract class ViewModel {
    private var isCleared = false

    actual val viewModelScope: CoroutineScope by lazy(::buildScope)

    private fun buildScope(): CloseableCoroutineScope = CloseableCoroutineScope(
        SupervisorJob() + Dispatchers.Main.immediate
    ).apply {
        if (isCleared) close()
    }

    protected actual open fun onCleared() {}

    fun clear() {
        isCleared = true
        viewModelScope.close()
        onCleared()
    }
}