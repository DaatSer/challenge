package com.example.crossmintchallenge.domain.models

data class Cometh(
    val row: Int,
    val column: Int,
    val direction: Direction,
) : MegaverseEntity {

    enum class Direction(val lowercaseName: String) {
        UP("up"),
        DOWN("down"),
        LEFT("left"),
        RIGHT("right"),
    }
}