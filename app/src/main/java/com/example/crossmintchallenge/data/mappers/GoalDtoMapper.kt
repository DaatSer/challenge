package com.example.crossmintchallenge.data.mappers

import com.example.crossmintchallenge.data.network.models.goal.GoalResponseDto
import com.example.crossmintchallenge.domain.models.Cometh
import com.example.crossmintchallenge.domain.models.GoalResponse
import com.example.crossmintchallenge.domain.models.Polyanet
import com.example.crossmintchallenge.domain.models.Soloon
import com.example.crossmintchallenge.domain.models.Space

internal fun GoalResponseDto.toDomain(): GoalResponse {
    return GoalResponse(
        megaverseMap = goal.mapIndexed { i, row ->
            row.mapIndexed { j, cell ->
                when (cell) {
                    "SPACE" -> Space(row = i, column = j)
                    "POLYANET" -> Polyanet(row = i, column = j)

                    "RED_SOLOON" -> Soloon(color = Soloon.SoloonColor.RED, row = i, column = j)
                    "PURPLE_SOLOON" -> Soloon(color = Soloon.SoloonColor.PURPLE, row = i, column = j)
                    "BLUE_SOLOON" -> Soloon(color = Soloon.SoloonColor.BLUE, row = i, column = j)
                    "WHITE_SOLOON" -> Soloon(color = Soloon.SoloonColor.WHITE, row = i, column = j)

                    "UP_COMETH" -> Cometh(direction = Cometh.Direction.UP, row = i, column = j)
                    "DOWN_COMETH" -> Cometh(direction = Cometh.Direction.DOWN, row = i, column = j)
                    "RIGHT_COMETH" -> Cometh(direction = Cometh.Direction.RIGHT, row = i, column = j)
                    "LEFT_COMETH" -> Cometh(direction = Cometh.Direction.LEFT, row = i, column = j)

                    else -> Space(row = i, column = j)
                }
            }
        }
    )
}