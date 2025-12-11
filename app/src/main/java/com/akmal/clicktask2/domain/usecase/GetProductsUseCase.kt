package com.akmal.clicktask2.domain.usecase

import com.akmal.clicktask2.domain.model.main.Product
import com.akmal.clicktask2.util.helper.Resource
import kotlinx.coroutines.flow.Flow

interface GetProductsUseCase {
    suspend operator fun invoke(): Resource<List<Product>>
}