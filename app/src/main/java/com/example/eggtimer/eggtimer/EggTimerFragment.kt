package com.example.eggtimer.eggtimer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.eggtimer.R
import com.example.eggtimer.databinding.FragmentEggtimerBinding

class EggTimerFragment: Fragment() {

    private lateinit var binding: FragmentEggtimerBinding
    private lateinit var viewModel: EggTimerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eggtimer, container, false)
        viewModel = ViewModelProviders.of(this).get(EggTimerViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}