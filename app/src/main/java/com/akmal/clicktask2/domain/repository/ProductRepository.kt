package com.akmal.clicktask2.domain.repository

import com.akmal.clicktask2.domain.model.main.Product
import com.akmal.clicktask2.util.helper.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Resource<List<Product>>
}