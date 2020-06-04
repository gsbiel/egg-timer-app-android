package com.example.eggtimer.eggtimer

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("progressValue")
fun ProgressBar.onSetProgress(value: Double){
    progress = value.toInt()
}