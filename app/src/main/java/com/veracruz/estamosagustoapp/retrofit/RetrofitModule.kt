package com.veracruz.estamosagustoapp.retrofit

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.veracruz.estamosagustoapp.data.Api
import com.veracruz.estamosagustoapp.datastore.StoreData
import com.veracruz.estamosagustoapp.retrofit.interceptor.AuthInterceptor
import com.veracruz.estamosagustoapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context: Context) : Api {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            //.client(provideOkHttpClient(context = context))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(context : Context): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(dataStore = StoreData(context)))
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(tokenManager: StoreData): AuthInterceptor =
        AuthInterceptor(tokenManager)

}