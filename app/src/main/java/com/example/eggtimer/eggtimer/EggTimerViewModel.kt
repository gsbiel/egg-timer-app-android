package com.example.eggtimer.eggtimer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class EggTimerViewModel: ViewModel() {

    val SOFT_TIME: Double = 10.0
    val MEDIUM_TIME: Double = 20.0
    val HARD_TIME: Double = 30.0

    private var _currentProgress = MutableLiveData<Double>()
    val currentProgress: LiveData<Double>
        get() = _currentProgress

    private val _currentMode: Double? = null

    init {
        _currentProgress.value = 0.0
    }

    fun onButtonPressed(mode: Double = SOFT_TIME){
        startTimerFor(mode)
    }

    private fun startTimerFor(time: Double) {
        Log.i("EggTimerViewModel", "Starting timer for $time seconds")
    }
}
