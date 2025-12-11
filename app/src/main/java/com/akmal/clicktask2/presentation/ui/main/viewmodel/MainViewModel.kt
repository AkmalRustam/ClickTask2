package com.akmal.clicktask2.presentation.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akmal.clicktask2.domain.model.main.Product
import com.akmal.clicktask2.domain.usecase.GetProductsUseCase
import com.akmal.clicktask2.util.helper.Resource
import com.akmal.clicktask2.util.helper.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _productsState = MutableStateFlow<UiState<List<Product>>>(UiState.Loading)
    val productsState = _productsState.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _productsState.value = UiState.Loading
            when (val resource = getProductsUseCase()) {
                is Resource.Error -> {
                    _productsState.value = UiState.Error(resource.message)
                }

                is Resource.Success -> {
                    _productsState.value = UiState.Success(resource.data)
                }
            }
        }
    }
}