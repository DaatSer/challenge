package com.example.crossmintchallenge.data.mappers

import com.example.crossmintchallenge.data.network.models.cometh.ComethRequestDto
import com.example.crossmintchallenge.domain.models.Cometh

internal fun Cometh.toRequestDto(candidateId: String): ComethRequestDto {
    return ComethRequestDto(
        row = row,
        column = column,
        direction = direction.lowercaseName,
        candidateId = candidateId,
    )
}