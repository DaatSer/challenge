package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.domain.models.MegaverseEntity
import com.example.crossmintchallenge.domain.models.Space
import javax.inject.Inject

internal interface GoalInteractor {

    suspend fun getRequiredGoal(): List<MegaverseEntity>

}

internal class GoalInteractorImpl @Inject constructor(
    private val megaverseRepository: MegaverseRepository,
) : GoalInteractor {

    override suspend fun getRequiredGoal(): List<MegaverseEntity> {
        val megaverse = megaverseRepository.getGoal().megaverseMap

        return megaverse.flatten().filter { it !is Space }
    }

}