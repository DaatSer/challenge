package com.example.crossmintchallenge.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crossmintchallenge.domain.interactors.ChallengeInteractor
import com.example.crossmintchallenge.domain.interactors.GoalInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val challengeInteractor: ChallengeInteractor,
    private val goalInteractor: GoalInteractor,
) : ViewModel() {

    fun start() {
        viewModelScope.launch {
            try {
                val entities = goalInteractor.getRequiredGoal()
                challengeInteractor.buildMegaverseFrom(entities)
            } catch (ex: Throwable) {
                Log.e("MainViewModel", "Something went wrong", ex)
            }
        }
    }
}