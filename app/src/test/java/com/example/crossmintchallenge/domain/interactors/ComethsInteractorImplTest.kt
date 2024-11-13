package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.data.repositories.MegaverseRepository
import com.example.crossmintchallenge.domain.models.Cometh
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ComethsInteractorTest {

    private lateinit var interactor: ComethsInteractor

    private val megaverseRepository: MegaverseRepository = mockk()

    @BeforeEach
    fun setup() {
        interactor = ComethsInteractorImpl(
            megaverseRepository = megaverseRepository
        )
    }

    @Test
    fun `GIVEN cometh WHEN setCometh THEN verify repository called`() = runTest {
        coEvery { megaverseRepository.setCometh(any()) } returns Unit

        val cometh = Cometh(
            row = 0,
            column = 1,
            direction = Cometh.Direction.UP
        )

        megaverseRepository.setCometh(cometh)

        coVerify(exactly = 1) { megaverseRepository.setCometh(cometh) }
    }

    @Test
    fun `GIVEN cometh WHEN deleteCometh THEN verify repository called`() = runTest {
        coEvery { megaverseRepository.deleteCometh(any()) } returns Unit

        val cometh = Cometh(
            row = 0,
            column = 1,
            direction = Cometh.Direction.UP
        )

        megaverseRepository.deleteCometh(cometh)

        coVerify(exactly = 1) { megaverseRepository.deleteCometh(cometh) }
    }

}