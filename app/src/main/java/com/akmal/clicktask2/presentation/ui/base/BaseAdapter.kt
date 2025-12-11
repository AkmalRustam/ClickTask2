package com.akmal.clicktask2.presentation.ui.base // Yoki .base papkasi

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T : Any, VB : ViewBinding>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseAdapter.BaseViewHolder<T, VB>>(diffCallback) {

    abstract override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<T, VB>

    override fun onBindViewHolder(holder: BaseViewHolder<T, VB>, position: Int) {
        holder.bind(getItem(position))
    }

    abstract class BaseViewHolder<T : Any, VB : ViewBinding>(protected val binding: VB) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            with(binding) {
                setupViews(item)
                setupValues(item)
                setupListeners(item)
            }
        }

        open fun VB.setupViews(item: T) {}

        open fun VB.setupValues(item: T) {}

        open fun VB.setupListeners(item: T) {}
    }
}