package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.domain.models.Polyanet
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PolyanetsInteractorTest {

    private lateinit var interactor: PolyanetsInteractor

    private val megaverseRepository: MegaverseRepository = mockk()

    @BeforeEach
    fun setup() {
        interactor = PolyanetsInteractorImpl(
            megaverseRepository = megaverseRepository,
        )
    }

    @Test
    fun `GIVEN polyanet WHEN setPolyanet THEN verify repository called`() = runTest {
        coEvery { megaverseRepository.setPolyanet(any()) } returns Unit

        val polyanet = Polyanet(row = 0, column = 1)

        megaverseRepository.setPolyanet(polyanet)

        coVerify(exactly = 1) { megaverseRepository.setPolyanet(polyanet) }
    }

    @Test
    fun `GIVEN polyanet WHEN deletePolyanet THEN verify repository called`() = runTest {
        coEvery { megaverseRepository.deletePolyanet(any()) } returns Unit

        val polyanet = Polyanet(row = 0, column = 1)

        megaverseRepository.deletePolyanet(polyanet)

        coVerify(exactly = 1) { megaverseRepository.deletePolyanet(polyanet) }
    }

}