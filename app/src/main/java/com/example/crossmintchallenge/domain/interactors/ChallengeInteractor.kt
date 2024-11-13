package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.domain.models.Cometh
import com.example.crossmintchallenge.domain.models.MegaverseEntity
import com.example.crossmintchallenge.domain.models.Polyanet
import com.example.crossmintchallenge.domain.models.Soloon
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

internal interface ChallengeInteractor {

    suspend fun buildMegaverseFrom(megaverseEntities: List<MegaverseEntity>)

}

internal class ChallengeInteractorImpl @Inject constructor(
    private val comethsInteractor: ComethsInteractor,
    private val soloonsInteractor: SoloonsInteractor,
    private val polyanetsInteractor: PolyanetsInteractor,
) : ChallengeInteractor {

    private val mutext = Mutex()

    override suspend fun buildMegaverseFrom(megaverseEntities: List<MegaverseEntity>) {
        return megaverseEntities.forEach { entity ->
            when (entity) {
                is Cometh -> mutext.withLock { comethsInteractor.setCometh(entity) }
                is Soloon -> mutext.withLock { soloonsInteractor.setSoloon(entity) }
                is Polyanet -> mutext.withLock { polyanetsInteractor.setPolyanet(entity) }
                else -> throw IllegalArgumentException("Megaverese entity $entity is not supported")
            }
        }
    }
}