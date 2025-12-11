package com.akmal.clicktask2.data.remote.source

import com.akmal.clicktask2.data.remote.model.main.ProductDto

interface RemoteDataSource {
    suspend fun getProducts(): List<ProductDto>
}