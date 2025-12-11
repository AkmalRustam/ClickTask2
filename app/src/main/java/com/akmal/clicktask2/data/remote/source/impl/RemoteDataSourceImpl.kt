package com.akmal.clicktask2.data.remote.source.impl

import com.akmal.clicktask2.data.remote.api.ProductService
import com.akmal.clicktask2.data.remote.model.main.ProductDto
import com.akmal.clicktask2.data.remote.source.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val productService: ProductService
) : RemoteDataSource {
    override suspend fun getProducts(): List<ProductDto> {
        return productService.getProducts()
    }
}