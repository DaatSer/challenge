package com.example.crossmintchallenge.data.network.models.polyanet

import com.google.gson.annotations.SerializedName

internal data class PolyanetRequestDto(
    @SerializedName("row") val row: Int,
    @SerializedName("column") val column: Int,
    @SerializedName("candidateId") val candidateId: String,
)