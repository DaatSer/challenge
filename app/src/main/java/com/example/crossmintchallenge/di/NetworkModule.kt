package com.example.crossmintchallenge.di

import com.example.crossmintchallenge.providers.NetworkConfigProvider
import com.example.crossmintchallenge.providers.NetworkConfigProviderImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkModule {

    @[Binds Singleton]
    abstract fun bindNetworkConfig(impl: NetworkConfigProviderImpl): NetworkConfigProvider

    @[Provides Singleton]
    fun  provideGson(): Gson {
        return GsonBuilder().create()
    }

    @[Provides Singleton]
    fun provideRetrofit(
        networkConfigProvider: NetworkConfigProvider,
        gson: Gson,
    ): Retrofit {
        return Retrofit.Builder()
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