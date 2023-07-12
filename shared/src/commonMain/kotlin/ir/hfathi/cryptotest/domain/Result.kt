package ir.hfathi.cryptotest.domain

sealed class Result<out A> {
    data class Success<out A>(val value: A) : Result<A>()
    data class Error(
        val code: Int? = null,
        val message: String? = null,
        val exception: Throwable? = null
    ) : Result<Nothing>()

    fun <B> map(m: ((A) -> B)): Result<B> = when (this) {
        is Success -> Success(m(this.value))
        is Error -> Error(this.code, this.message, this.exception)
    }
}

/**
 * Call the specific action in [callback] if the result is [Result.Success] and not null.
 */
inline fun <reified A> Result<A>.doIfSuccess(callback: (value: A) -> Unit): Result<A> {
    (this as? Result.Success)?.value?.let { callback(it) }
    return this
}

/**
 * Call the specific action in [callback] if the result is [Result.Error].
 */
inline fun <reified A> Result<A>.doIfError(callback: (error: Result.Error) -> Unit): Result<A> {
    (this as? Result.Error)?.let { callback(it) }
    return this
}

/**
 * Specify a default value if a given result is not [Result.Success], otherwise it
 * returns the success value.
 */
inline fun <A> Result<A>.withDefault(default: () -> A): Result.Success<A> {
    return when (this) {
        is Result.Success -> this
        else -> Result.Success(default())
    }
}