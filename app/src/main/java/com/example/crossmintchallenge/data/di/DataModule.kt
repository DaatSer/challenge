package com.example.crossmintchallenge.data.di

import com.example.crossmintchallenge.data.network.MegaverseApiService
import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.data.repositories.MegaverseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindMegaverseRepository(impl: MegaverseRepositoryImpl): MegaverseRepository

    companion object {

        @[Provides Singleton]
        fun provideApiService(retrofit: Retrofit): MegaverseApiService {
            return retrofit.create(MegaverseApiService::class.java)
        }
    }
}