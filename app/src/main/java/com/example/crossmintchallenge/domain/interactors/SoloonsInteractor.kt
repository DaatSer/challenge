package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.domain.models.Soloon
import javax.inject.Inject

internal interface SoloonsInteractor {

    suspend fun setSoloon(soloon: Soloon)

    suspend fun deleteSoloon(soloon: Soloon)

}

internal class SoloonsInteractorImpl @Inject constructor(
    private val megaverseRepository: MegaverseRepository
) : SoloonsInteractor {

    override suspend fun setSoloon(soloon: Soloon) {
        return megaverseRepository.setSoloon(soloon)
    }

    override suspend fun deleteSoloon(soloon: Soloon) {
        return megaverseRepository.deleteSoloon(soloon)
    }
}