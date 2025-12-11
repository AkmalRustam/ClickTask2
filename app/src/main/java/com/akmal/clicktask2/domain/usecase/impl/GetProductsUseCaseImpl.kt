package com.akmal.clicktask2.domain.usecase.impl

import com.akmal.clicktask2.domain.model.main.Product
import com.akmal.clicktask2.domain.repository.ProductRepository
import com.akmal.clicktask2.domain.usecase.GetProductsUseCase
import com.akmal.clicktask2.util.helper.Resource
import javax.inject.Inject

class GetProductsUseCaseImpl @Inject constructor(private val productRepository: ProductRepository) :
    GetProductsUseCase {
    override suspend fun invoke(): Resource<List<Product>> {
        return productRepository.getProducts()
    }
}