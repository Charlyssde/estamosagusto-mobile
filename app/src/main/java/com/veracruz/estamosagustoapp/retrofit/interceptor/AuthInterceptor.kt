package com.veracruz.estamosagustoapp.retrofit.interceptor

import com.veracruz.estamosagustoapp.datastore.StoreData
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val dataStore: StoreData,
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking {
            dataStore.getToken
        }
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer $token")
        return chain.proceed(request.build())
    }
}