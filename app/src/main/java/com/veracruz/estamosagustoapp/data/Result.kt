package com.veracruz.estamosagustoapp.data

sealed class Result<T>(
    val message: String? = null,
    val data: T? = null
) {
    class Success<T>(data: T? = null, message: String? = null): Result<T>(data = data, message = message)
    class Error<T>(message: String? = null): Result<T>(message = message)
}