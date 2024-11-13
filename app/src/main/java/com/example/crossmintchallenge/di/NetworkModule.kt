package com.example.crossmintchallenge.di

import com.example.crossmintchallenge.utils.providers.NetworkConfigProvider
import com.example.crossmintchallenge.utils.providers.NetworkConfigProviderImpl
import com.example.crossmintchallenge.utils.interceptors.RetryInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @[Provides Singleton]
    fun bindNetworkConfig(): NetworkConfigProvider {
        return NetworkConfigProviderImpl()
    }

    @[Provides Singleton]
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @[Provides Singleton]
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @[Provides Singleton]
    fun provideRetryInterceptor(): RetryInterceptor {
        return RetryInterceptor()
    }

    @[Provides Singleton]
    fun provideOkHttp(
        loggingInterceptor: HttpLoggingInterceptor,
        retryInterceptor: RetryInterceptor,
    ): OkHttpClient {
        // SSL protocol fix
        val trustAllCerts = arrayOf<javax.net.ssl.TrustManager>(
            object : javax.net.ssl.X509TrustManager {
                override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {}
                override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {}
                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf()
            }
        )
        val sslContext = javax.net.ssl.SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        return OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as javax.net.ssl.X509TrustManager)
            .hostnameVerifier { _, _ -> true }
            .addInterceptor(loggingInterceptor)
            .addInterceptor(retryInterceptor)
            .build()
    }

    @[Provides Singleton]
    fun provideRetrofit(
        networkConfigProvider: NetworkConfigProvider,
        okHttpClient: OkHttpClient,
        gson: Gson,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(
                HttpUrl.Builder()
                    .scheme(networkConfigProvider.scheme())
                    .host(networkConfigProvider.baseUrl())
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}