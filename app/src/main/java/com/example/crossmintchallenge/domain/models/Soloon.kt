package com.example.crossmintchallenge.domain.models

data class Soloon(
    val row: Int,
    val column: Int,
    val color: SoloonColor,
) : MegaverseEntity {

    enum class SoloonColor(val lowercaseName: String) {
        WHITE("white"),
        BLUE("blue"),
        PURPLE("purple"),
        RED("red"),
    }

}