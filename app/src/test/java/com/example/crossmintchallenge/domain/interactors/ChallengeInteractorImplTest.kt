package com.example.crossmintchallenge.domain.interactors

import com.example.crossmintchallenge.domain.models.Cometh
import com.example.crossmintchallenge.domain.models.Polyanet
import com.example.crossmintchallenge.domain.models.Soloon
import com.example.crossmintchallenge.domain.models.Space
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ChallengeInteractorTest {

    private lateinit var challengeInteractor: ChallengeInteractor

    private val comethsInteractor: ComethsInteractor = mockk()
    private val soloonsInteractor: SoloonsInteractor = mockk()
    private val polyanetsInteractor: PolyanetsInteractor = mockk()

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeEach
    fun setup() {
        challengeInteractor = ChallengeInteractorImpl(
            comethsInteractor, soloonsInteractor, polyanetsInteractor
        )

        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun `GIVEN megaverseEntities WHEN buildMegaverseFrom THEN verify interactors called`() =
        runTest {
            coEvery { comethsInteractor.setCometh(any()) } returns Unit
            coEvery { soloonsInteractor.setSoloon(any()) } returns Unit
            coEvery { polyanetsInteractor.setPolyanet(any()) } returns Unit

            val megaverseEntities = listOf(
                Cometh(0, 0, Cometh.Direction.UP),
                Soloon(1, 1, Soloon.SoloonColor.RED),
                Polyanet(2, 2)
            )

            challengeInteractor.buildMegaverseFrom(megaverseEntities)

            coVerify(exactly = 1) { comethsInteractor.setCometh(megaverseEntities[0] as Cometh) }
            coVerify(exactly = 1) { soloonsInteractor.setSoloon(megaverseEntities[1] as Soloon) }
            coVerify(exactly = 1) { polyanetsInteractor.setPolyanet(megaverseEntities[2] as Polyanet) }
        }

    @Test
    fun `GIVEN megaverseEntities with unsupported entity WHEN buildMegaverseFrom THEN throw exception`() =
        runTest {
            coEvery { comethsInteractor.setCometh(any()) } returns Unit
            coEvery { soloonsInteractor.setSoloon(any()) } returns Unit
            coEvery { polyanetsInteractor.setPolyanet(any()) } returns Unit

            val megaverseEntities = listOf(
                Cometh(0, 0, Cometh.Direction.UP),
                Soloon(1, 1, Soloon.SoloonColor.RED),
                Polyanet(2, 2),
                Space(2, 2)
            )

            val exception = assertThrows<IllegalArgumentException> {
                challengeInteractor.buildMegaverseFrom(megaverseEntities)
            }
            assertEquals(
                "Megaverese entity Space(row=2, column=2) is not supported",
                exception.message
            )
        }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
