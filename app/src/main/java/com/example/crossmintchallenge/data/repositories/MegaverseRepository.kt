package com.example.crossmintchallenge.data.repositories

import com.example.crossmintchallenge.BuildConfig
import com.example.crossmintchallenge.data.mappers.toDomain
import com.example.crossmintchallenge.data.mappers.toRequestDto
import com.example.crossmintchallenge.data.network.MegaverseApiService
import com.example.crossmintchallenge.domain.models.Cometh
import com.example.crossmintchallenge.domain.models.GoalResponse
import com.example.crossmintchallenge.domain.models.Polyanet
import com.example.crossmintchallenge.domain.models.Soloon
import com.example.crossmintchallenge.utils.onIo
import javax.inject.Inject

internal interface MegaverseRepository {

    suspend fun setPolyanet(polyanet: Polyanet)

    suspend fun deletePolyanet(polyanet: Polyanet)

    suspend fun setSoloon(soloon: Soloon)

    suspend fun deleteSoloon(soloon: Soloon)

    suspend fun setCometh(cometh: Cometh)

    suspend fun deleteCometh(cometh: Cometh)

    suspend fun getGoal(): GoalResponse

}

internal class MegaverseRepositoryImpl @Inject constructor(
    private val megaverseApiService: MegaverseApiService,
) : MegaverseRepository {

    override suspend fun setPolyanet(polyanet: Polyanet) = onIo {
        val request = polyanet.toRequestDto(BuildConfig.CANDIDATE_ID)

        megaverseApiService.setPolyanet(request)
    }

    override suspend fun deletePolyanet(polyanet: Polyanet) = onIo {
        val request = polyanet.toRequestDto(BuildConfig.CANDIDATE_ID)

        megaverseApiService.deletePolyanet(request)
    }

    override suspend fun setSoloon(soloon: Soloon) = onIo {
        val request = soloon.toRequestDto(BuildConfig.CANDIDATE_ID)

        megaverseApiService.setSoloon(request)
    }

    override suspend fun deleteSoloon(soloon: Soloon) = onIo {
        val request = soloon.toRequestDto(BuildConfig.CANDIDATE_ID)

        megaverseApiService.deleteSoloon(request)
    }

    override suspend fun setCometh(cometh: Cometh) = onIo {
        val request = cometh.toRequestDto(BuildConfig.CANDIDATE_ID)

        megaverseApiService.setCometh(request)
    }

    override suspend fun deleteCometh(cometh: Cometh) = onIo {
        val request = cometh.toRequestDto(BuildConfig.CANDIDATE_ID)

        megaverseApiService.deleteCometh(request)
    }

    override suspend fun getGoal(): GoalResponse = onIo {
        megaverseApiService.getGoal(BuildConfig.CANDIDATE_ID).toDomain()
    }
}