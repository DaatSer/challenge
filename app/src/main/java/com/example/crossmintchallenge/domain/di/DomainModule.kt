package com.example.crossmintchallenge.domain.di

import com.example.crossmintchallenge.domain.interactors.ChallengeInteractor
import com.example.crossmintchallenge.domain.interactors.ChallengeInteractorImpl
import com.example.crossmintchallenge.domain.interactors.ComethsInteractor
import com.example.crossmintchallenge.domain.interactors.ComethsInteractorImpl
import com.example.crossmintchallenge.domain.interactors.GoalInteractor
import com.example.crossmintchallenge.domain.interactors.GoalInteractorImpl
import com.example.crossmintchallenge.domain.interactors.PolyanetsInteractor
import com.example.crossmintchallenge.domain.interactors.PolyanetsInteractorImpl
import com.example.crossmintchallenge.domain.interactors.SoloonsInteractor
import com.example.crossmintchallenge.domain.interactors.SoloonsInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DomainModule {

    @Binds
    fun bindPolyanetsInteractor(impl: PolyanetsInteractorImpl): PolyanetsInteractor

    @Binds
    fun bindGoalInteractor(impl: GoalInteractorImpl): GoalInteractor

    @Binds
    fun bindSoloonsInteractor(impl: SoloonsInteractorImpl): SoloonsInteractor

    @Binds
    fun bindComethsInteractor(impl: ComethsInteractorImpl): ComethsInteractor

    @Binds
    fun bindChallengeInteractor(impl: ChallengeInteractorImpl): ChallengeInteractor

}