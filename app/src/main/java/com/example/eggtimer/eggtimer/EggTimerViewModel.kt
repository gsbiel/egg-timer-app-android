package com.example.eggtimer.eggtimer

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class EggTimerViewModel: ViewModel(), MyTimerDelegate {

    val SOFT_TIME: Long = 10000
    val MEDIUM_TIME: Long = 20000
    val HARD_TIME: Long = 30000

    private var _currentProgress = MutableLiveData<Int>()
    val currentProgress: LiveData<Int>
        get() = _currentProgress

    private var currentMode: Long? = null
    private var timer: MyTimer? = null

    init {
        _currentProgress.value = 0
    }

    fun onButtonPressed(mode: Long = SOFT_TIME){
        timer?.let{
            it.cancel()
        }
        currentMode = mode
        setTimerFor(mode)
    }

    private fun setTimerFor(time: Long){
        timer = MyTimer(this, time)
        timer?.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer?.let{
            it.cancel()
        }
        timer = null
    }

    override fun onTimerTick(millisUntilFinished: Long, total: Long) {
        Log.i("MyTimer","Timer is counting: ${(millisUntilFinished/1000.0).roundToInt()} / ${total/1000}")
        val progress: Int = (((millisUntilFinished/1000.0)/(total/1000.0))*100).roundToInt()
        _currentProgress.value = progress
    }

    override fun onTimerFinished() {
        Log.i("MyTimer", "Timer completed!")
        _currentProgress.value = 0
    }
}

private class MyTimer(val delegate: MyTimerDelegate, val total: Long, tick: Long = 1000): CountDownTimer(total, tick) {
    override fun onFinish() {
        delegate.onTimerFinished()
    }
    override fun onTick(millisUntilFinished: Long) {
        delegate.onTimerTick(millisUntilFinished, total)
    }
}

private interface MyTimerDelegate {
    fun onTimerTick(millisUntilFinished: Long, total: Long)
    fun onTimerFinished()
}
