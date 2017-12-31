package com.aliak.dev.fastreading.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aliak.dev.fastreading.databinding.ViewModelLifecycle

abstract class BaseLifecycleActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModelLifecycle
    abstract fun initViewModel(): ViewModelLifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = initViewModel()
        viewModel.initialize()
    }

    override fun onResume() {
        super.onResume()
        viewModel.resume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.initialize()
    }
}