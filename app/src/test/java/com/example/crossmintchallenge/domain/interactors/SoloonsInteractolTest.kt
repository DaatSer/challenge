package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.domain.models.Soloon
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SoloonsInteractorTest {

    private lateinit var interactor: SoloonsInteractor

    private val megaverseRepository: MegaverseRepository = mockk()

    @BeforeEach
    fun setup() {
        interactor = SoloonsInteractorImpl(
            megaverseRepository = megaverseRepository,
        )
    }

    @Test
    fun `GIVEN soloon WHEN setSoloon THEN verify repository called`() = runTest {
        coEvery { megaverseRepository.setSoloon(any()) } returns Unit

        val soloon = Soloon(
            row = 0,
            column = 1,
            color = Soloon.SoloonColor.RED
        )

        megaverseRepository.setSoloon(soloon)

        coVerify(exactly = 1) { megaverseRepository.setSoloon(soloon) }
    }

    @Test
    fun `GIVEN soloon WHEN deleteSoloon THEN verify repository called`() = runTest {
        coEvery { megaverseRepository.deleteSoloon(any()) } returns Unit

        val soloon = Soloon(
            row = 0,
            column = 1,
            color = Soloon.SoloonColor.RED
        )

        megaverseRepository.deleteSoloon(soloon)

        coVerify(exactly = 1) { megaverseRepository.deleteSoloon(soloon) }
    }

}