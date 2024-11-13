package com.example.crossmintchallenge.data.mappers

import com.example.crossmintchallenge.data.network.models.soloon.SoloonRequestDto
import com.example.crossmintchallenge.domain.models.Soloon

internal fun Soloon.toRequestDto(candidateId: String): SoloonRequestDto {
    return SoloonRequestDto(
        row = row,
        column = column,
        color = color.lowercaseName,
        candidateId = candidateId
    )
}