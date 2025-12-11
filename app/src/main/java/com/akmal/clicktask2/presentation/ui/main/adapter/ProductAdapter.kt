package com.akmal.clicktask2.presentation.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.akmal.clicktask2.databinding.RecyclerViewProductsItemBinding
import com.akmal.clicktask2.domain.model.main.Product
import com.akmal.clicktask2.presentation.ui.base.BaseAdapter
import com.akmal.clicktask2.util.extension.formatPriceWithDollar
import com.akmal.clicktask2.util.extension.setImageWithGlideAndCircularProgress

class ProductAdapter(
    private val onClick: (Product) -> Unit
) : BaseAdapter<Product, RecyclerViewProductsItemBinding>(ProductDiffCallback) {

    inner class ProductViewHolder(binding: RecyclerViewProductsItemBinding) :
        BaseViewHolder<Product, RecyclerViewProductsItemBinding>(binding) {

        override fun RecyclerViewProductsItemBinding.setupValues(
            item: Product
        ) {

        }

        override fun RecyclerViewProductsItemBinding.setupListeners(
            item: Product
        ) {
            root.setOnClickListener {
                onClick(item)
            }
        }

        override fun RecyclerViewProductsItemBinding.setupViews(
            item: Product
        ) {
            ivProductImage.setImageWithGlideAndCircularProgress(item.image)
            tvProductName.apply{
                isSelected = true
                text = item.title
            }
            tvProductDescription.text = item.description
            tvProductPrice.text = item.price.formatPriceWithDollar()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Product, RecyclerViewProductsItemBinding> {
        return ProductViewHolder(
            RecyclerViewProductsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    companion object ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}
