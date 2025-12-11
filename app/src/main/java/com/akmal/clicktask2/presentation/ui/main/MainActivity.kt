package com.akmal.clicktask2.presentation.ui.main

import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.akmal.clicktask2.R
import com.akmal.clicktask2.databinding.ActivityMainBinding
import com.akmal.clicktask2.domain.model.main.Product
import com.akmal.clicktask2.presentation.ui.base.BaseActivity
import com.akmal.clicktask2.presentation.ui.main.adapter.ProductAdapter
import com.akmal.clicktask2.presentation.ui.main.viewmodel.MainViewModel
import com.akmal.clicktask2.util.extension.invisible
import com.akmal.clicktask2.util.extension.showMessage
import com.akmal.clicktask2.util.extension.visible
import com.akmal.clicktask2.util.helper.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()
    private val productAdapter by lazy {
        ProductAdapter(this::onProductClick)
    }

    override fun ActivityMainBinding.setupViews() {
        setupRecyclerView()
    }

    override fun ActivityMainBinding.setupListeners() {
        setPaddingToSystemBars()
    }

    override fun ActivityMainBinding.setupObservables() {
        lifecycleScope.launch {
            observeProduct()
        }
    }

    private suspend fun observeProduct() {
        viewModel.productsState.collectLatest { state ->
            when (state) {
                is UiState.Loading -> showLoading()
                is UiState.Success -> handleProducts(state.data)
                is UiState.Error -> showError(state.message)
            }
        }
    }

    private fun showError(message: String) {
        showMessage(message)
    }

    private fun showLoading() {
        binding.productProgressBar.visible()
    }

    private fun dismissLoading() {
        binding.productProgressBar.invisible()
    }

    private fun handleProducts(products: List<Product>) {
        dismissLoading()
        productAdapter.submitList(products)
    }

    private fun setPaddingToSystemBars() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun onProductClick(product: Product) {
        showMessage(product.title)
    }

    private fun ActivityMainBinding.setupRecyclerView() {
        val productRecyclerViewLayoutManager = GridLayoutManager(
            this@MainActivity,
            2,
            GridLayoutManager.VERTICAL,
            false
        )
        recyclerViewProducts.apply {
            layoutManager = productRecyclerViewLayoutManager
            adapter = productAdapter
            setHasFixedSize(true)
        }
    }

    companion object {
        private const val TAG = "MainActivityTag"
    }
}
