package com.example.eggtimer.eggtimer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.eggtimer.R
import com.example.eggtimer.databinding.FragmentEggtimerBinding

class EggTimerFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentEggtimerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_eggtimer, container, false)
        return binding.root
    }
}