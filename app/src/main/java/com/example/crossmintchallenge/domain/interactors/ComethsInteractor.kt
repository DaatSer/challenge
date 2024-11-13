package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.domain.models.Cometh
import javax.inject.Inject

internal interface ComethsInteractor {

    suspend fun setCometh(cometh: Cometh)

    suspend fun deleteCometh(cometh: Cometh)

}

internal class ComethsInteractorImpl @Inject constructor(
    private val megaverseRepository: MegaverseRepository
) : ComethsInteractor {

    override suspend fun setCometh(cometh: Cometh) {
        return megaverseRepository.setCometh(cometh)
    }

    override suspend fun deleteCometh(cometh: Cometh) {
        return megaverseRepository.deleteCometh(cometh)
    }
}