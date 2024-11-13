package com.example.crossmintchallenge.data.network.models.soloon

import com.google.gson.annotations.SerializedName

internal data class SoloonRequestDto(
    @SerializedName("row") val row: Int,
    @SerializedName("column") val column: Int,
    @SerializedName("color") val color: String,
    @SerializedName("candidateId") val candidateId: String,
)