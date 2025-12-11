package com.akmal.clicktask2.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding>(
    private val inflate: (LayoutInflater) -> VB
) : AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            setupValues()
            setupViews()
            setupListeners()
            setupObservables()
        }
    }

    open fun VB.setupValues() {}
    open fun VB.setupViews() {}
    open fun VB.setupListeners() {}
    open fun VB.setupObservables() {}

    open fun loadDatasFromNetwork() {}
}