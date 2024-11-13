package com.example.crossmintchallenge.data.network

import com.example.crossmintchallenge.data.network.models.cometh.ComethRequestDto
import com.example.crossmintchallenge.data.network.models.goal.GoalResponseDto
import com.example.crossmintchallenge.data.network.models.polyanet.PolyanetRequestDto
import com.example.crossmintchallenge.data.network.models.soloon.SoloonRequestDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

internal interface MegaverseApiService {

    @POST("api/polyanets")
    suspend fun setPolyanet(@Body request: PolyanetRequestDto)

    @DELETE("api/polyanets")
    suspend fun deletePolyanet(@Body request: PolyanetRequestDto)

    @POST("api/soloons")
    suspend fun setSoloon(@Body request: SoloonRequestDto)

    @DELETE("api/soloons")
    suspend fun deleteSoloon(@Body request: SoloonRequestDto)

    @POST("api/comeths")
    suspend fun setCometh(@Body request: ComethRequestDto)

    @DELETE("api/comeths")
    suspend fun deleteCometh(@Body request: ComethRequestDto)

    @GET("api/map/{id}/goal")
    suspend fun getGoal(@Path("id") candidateId: String): GoalResponseDto
}