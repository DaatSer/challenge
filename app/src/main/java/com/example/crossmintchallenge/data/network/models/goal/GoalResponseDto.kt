package com.example.crossmintchallenge.data.network.models.goal

import com.google.gson.annotations.SerializedName

data class GoalResponseDto(
    @SerializedName("goal") val goal: List<List<String>>
)