package com.example.crossmintchallenge.data.repositories

import com.example.crossmintchallenge.BuildConfig
import com.example.crossmintchallenge.data.network.MegaverseApiService
import com.example.crossmintchallenge.data.network.models.cometh.ComethRequestDto
import com.example.crossmintchallenge.data.network.models.goal.GoalResponseDto
import com.example.crossmintchallenge.data.network.models.polyanet.PolyanetRequestDto
import com.example.crossmintchallenge.data.network.models.soloon.SoloonRequestDto
import com.example.crossmintchallenge.domain.models.Cometh
import com.example.crossmintchallenge.domain.models.GoalResponse
import com.example.crossmintchallenge.domain.models.Polyanet
import com.example.crossmintchallenge.domain.models.Soloon
import com.example.crossmintchallenge.domain.models.Space
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MegaverseRepositoryTest {

    private lateinit var repository: MegaverseRepository

    private val megaverseApiService: MegaverseApiService = mockk()

    @BeforeEach
    fun setup() {
        repository = MegaverseRepositoryImpl(
            megaverseApiService = megaverseApiService,
        )
    }

    @Test
    fun `GIVEN polyanet WHEN setPolyanet THEN verify call`() = runTest {
        coEvery { megaverseApiService.setPolyanet(any())} returns Unit

        val polyanet = Polyanet(
            row = 0,
            column = 1,
        )

        repository.setPolyanet(polyanet)

        coVerify(exactly = 1) {
            megaverseApiService.setPolyanet(
                PolyanetRequestDto(
                    0,
                    1,
                    BuildConfig.CANDIDATE_ID
                )
            )
        }
    }

    @Test
    fun `GIVEN polyanet AND error WHEN setPolyanet THEN throw exception`() = runTest {
        coEvery { megaverseApiService.setPolyanet(any()) } throws IllegalStateException()

        val polyanet = Polyanet(
            row = 0,
            column = 1,
        )

        assertThrows<IllegalStateException> { repository.setPolyanet(polyanet) }
        coVerify(exactly = 1) {
            megaverseApiService.setPolyanet(
                PolyanetRequestDto(
                    0,
                    1,
                    BuildConfig.CANDIDATE_ID
                )
            )
        }
    }

    @Test
    fun `GIVEN soloon WHEN setSoloon THEN verify call`() = runTest {
        coEvery { megaverseApiService.setSoloon(any()) } returns Unit

        val soloon = Soloon(row = 0, column = 1, color = Soloon.SoloonColor.RED)

        repository.setSoloon(soloon)

        coVerify(exactly = 1) {
            megaverseApiService.setSoloon(
                SoloonRequestDto(0, 1, "red", BuildConfig.CANDIDATE_ID)
            )
        }
    }

    @Test
    fun `GIVEN soloon AND error WHEN setSoloon THEN throw exception`() = runTest {
        coEvery { megaverseApiService.setSoloon(any()) } throws IllegalStateException()

        val soloon = Soloon(row = 0, column = 1, color = Soloon.SoloonColor.RED)

        assertThrows<IllegalStateException> { repository.setSoloon(soloon) }
        coVerify(exactly = 1) {
            megaverseApiService.setSoloon(
                SoloonRequestDto(0, 1, "red", BuildConfig.CANDIDATE_ID)
            )
        }
    }

    @Test
    fun `GIVEN soloon WHEN deleteSoloon THEN verify call`() = runTest {
        coEvery { megaverseApiService.deleteSoloon(any()) } returns Unit

        val soloon = Soloon(row = 0, column = 1, color = Soloon.SoloonColor.RED)

        repository.deleteSoloon(soloon)

        coVerify(exactly = 1){
            megaverseApiService.deleteSoloon(
                SoloonRequestDto(0, 1, "red", BuildConfig.CANDIDATE_ID)
            )
        }
    }

    @Test
    fun `GIVEN soloon AND error WHEN deleteSoloon THEN throw exception`() = runTest {
        coEvery { megaverseApiService.deleteSoloon(any()) } throws IllegalStateException()

        val soloon = Soloon(row = 0, column = 1, color = Soloon.SoloonColor.RED)

        assertThrows<IllegalStateException> { repository.deleteSoloon(soloon) }
        coVerify(exactly = 1) {
            megaverseApiService.deleteSoloon(
                SoloonRequestDto(0, 1, "red", BuildConfig.CANDIDATE_ID)
            )
        }
    }

    @Test
    fun `GIVEN cometh WHEN setCometh THEN verify call`() = runTest {
        coEvery { megaverseApiService.setCometh(any()) } returns Unit

        val cometh = Cometh(row = 0, column = 1, direction = Cometh.Direction.UP)

        repository.setCometh(cometh)

        coVerify(exactly = 1) {
            megaverseApiService.setCometh(
                ComethRequestDto(0, 1, "up", BuildConfig.CANDIDATE_ID)
            )
        }
    }

    @Test
    fun `GIVEN cometh AND error WHEN setCometh THEN throw exception`() = runTest {
        coEvery { megaverseApiService.setCometh(any()) } throws IllegalStateException()

        val cometh = Cometh(row = 0, column = 1, direction = Cometh.Direction.UP)

        assertThrows<IllegalStateException> { repository.setCometh(cometh) }
        coVerify(exactly = 1) {
            megaverseApiService.setCometh(
                ComethRequestDto(0, 1, "up", BuildConfig.CANDIDATE_ID)
            )
        }
    }

    @Test
    fun `GIVEN cometh WHEN deleteCometh THEN verify call`() = runTest {
        coEvery { megaverseApiService.deleteCometh(any()) } returns Unit

        val cometh = Cometh(row= 0, column = 1, direction = Cometh.Direction.UP)

        repository.deleteCometh(cometh)

        coVerify(exactly = 1) {
            megaverseApiService.deleteCometh(
                ComethRequestDto(0, 1, "up", BuildConfig.CANDIDATE_ID)
            )
        }
    }

    @Test
    fun `GIVEN cometh AND error WHEN deleteCometh THEN throw exception`() = runTest {
        coEvery { megaverseApiService.deleteCometh(any()) } throws IllegalStateException()

        val cometh = Cometh(row = 0, column = 1, direction = Cometh.Direction.UP)

        assertThrows<IllegalStateException> { repository.deleteCometh(cometh) }
        coVerify(exactly = 1) {
            megaverseApiService.deleteCometh(
                ComethRequestDto(0, 1, "up", BuildConfig.CANDIDATE_ID)
            )
        }
    }

    @Test
    fun `GIVEN empty response WHEN getGoal THEN return goal state`() = runTest {
        coEvery { megaverseApiService.getGoal(any()) } returns GoalResponseDto(emptyList())

        val actualGoal = repository.getGoal()

        assertEquals(GoalResponse(emptyList()), actualGoal)
        coVerify(exactly = 1) { megaverseApiService.getGoal(BuildConfig.CANDIDATE_ID) }
    }

    @Test
    fun `GIVEN response WHEN getGoal THEN return goal state`() = runTest {
        coEvery { megaverseApiService.getGoal(any()) } returns GoalResponseDto(listOf(listOf("SPACE")))

        val actualGoal = repository.getGoal()

        assertEquals(GoalResponse(listOf(listOf(Space(0, 0)))), actualGoal)
        coVerify(exactly = 1) { megaverseApiService.getGoal(BuildConfig.CANDIDATE_ID) }
    }

    @Test
    fun `WHEN getGoal AND error THEN throw exception`() = runTest {
        coEvery { megaverseApiService.getGoal(any()) } throws IllegalStateException()

        assertThrows<IllegalStateException> { repository.getGoal() }
        coVerify(exactly = 1) { megaverseApiService.getGoal(BuildConfig.CANDIDATE_ID) }
    }

}