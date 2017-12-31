package com.aliak.dev.fastreading.ui

import android.databinding.DataBindingUtil
import com.aliak.dev.fastreading.R
import com.aliak.dev.fastreading.databinding.ActivityMainBinding
import com.aliak.dev.fastreading.databinding.ViewModelLifecycle
import com.aliak.dev.fastreading.databinding.viewmodel.MainScreenViewModel

class MainActivity : BaseLifecycleActivity() {
    override fun initViewModel(): ViewModelLifecycle {
        val binding = DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = MainScreenViewModel()
        return binding.viewModel
    }

}
