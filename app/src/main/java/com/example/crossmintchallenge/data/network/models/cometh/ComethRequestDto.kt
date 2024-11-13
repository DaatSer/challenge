package com.example.crossmintchallenge.data.network.models.cometh

import com.google.gson.annotations.SerializedName

internal data class ComethRequestDto(
    @SerializedName("row") val row: Int,
    @SerializedName("column") val column: Int,
    @SerializedName("direction") val direction: String,
    @SerializedName("candidateId") val candidateId: String,
)