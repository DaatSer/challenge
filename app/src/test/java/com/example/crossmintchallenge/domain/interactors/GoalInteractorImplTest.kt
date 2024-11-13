package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.domain.models.GoalResponse
import com.example.crossmintchallenge.domain.models.Polyanet
import com.example.crossmintchallenge.domain.models.Soloon
import com.example.crossmintchallenge.domain.models.Space
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class GoalInteractorTest {

    private lateinit var interactor: GoalInteractor

    private val megaverseRepository: MegaverseRepository = mockk()

    @BeforeEach
    fun setup() {
        interactor = GoalInteractorImpl(
            megaverseRepository = megaverseRepository,
        )
    }

    @Test
    fun `WHEN getRequiredGoal THEN return expected entities`() = runTest {
        val goalResponse = GoalResponse(
            listOf(
                listOf(Polyanet(0, 0), Soloon(0, 1, Soloon.SoloonColor.RED), Space(0, 2)),
                listOf(Space(1, 0), Polyanet(1, 1), Soloon(1, 2, Soloon.SoloonColor.BLUE))
            )
        )
        coEvery { megaverseRepository.getGoal() } returns goalResponse

        val result = interactor.getRequiredGoal()

        val expectedEntities = listOf(
            Polyanet(0, 0),
            Soloon(0, 1, Soloon.SoloonColor.RED),
            Polyanet(1, 1),
            Soloon(1, 2, Soloon.SoloonColor.BLUE)
        )
        assertEquals(expectedEntities, result)
    }

    @Test
    fun `WHEN getRequiredGoal AND repository throws error THEN throw exception`() = runTest {
        val error = Exception("Failed to fetch goal")
        coEvery { megaverseRepository.getGoal() } throws error

        assertThrows<Exception> { interactor.getRequiredGoal() }
    }
}