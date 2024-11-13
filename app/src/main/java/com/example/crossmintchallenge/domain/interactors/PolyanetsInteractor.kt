package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.domain.models.Polyanet
import javax.inject.Inject

internal interface PolyanetsInteractor {

    suspend fun setPolyanet(polyanet: Polyanet)

    suspend fun deletePolyanet(polyanet: Polyanet)
}

internal class PolyanetsInteractorImpl @Inject constructor(
    private val megaverseRepository: MegaverseRepository,
) : PolyanetsInteractor {

    override suspend fun setPolyanet(polyanet: Polyanet) {
        return megaverseRepository.setPolyanet(polyanet)
    }

    override suspend fun deletePolyanet(polyanet: Polyanet) {
        return megaverseRepository.deletePolyanet(polyanet)
    }
}