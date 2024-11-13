package com.example.crossmintchallenge.data.mappers

import com.example.crossmintchallenge.data.network.models.polyanet.PolyanetRequestDto
import com.example.crossmintchallenge.domain.models.Polyanet

internal fun Polyanet.toRequestDto(candidateId: String): PolyanetRequestDto {
    return PolyanetRequestDto(
        row = row,
        column = column,
        candidateId = candidateId,
    )
}
