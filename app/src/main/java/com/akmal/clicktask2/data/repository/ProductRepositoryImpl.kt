package com.akmal.clicktask2.data.repository

import com.akmal.clicktask2.data.remote.mapper.toDomain
import com.akmal.clicktask2.data.remote.source.RemoteDataSource
import com.akmal.clicktask2.di.IoDispatcher
import com.akmal.clicktask2.domain.model.main.Product
import com.akmal.clicktask2.domain.repository.ProductRepository
import com.akmal.clicktask2.util.extension.safeApiCall
import com.akmal.clicktask2.util.helper.Resource
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ProductRepository {
    override suspend fun getProducts(): Resource<List<Product>> {
        return safeApiCall(
            ioDispatcher,
            apiCall = {
                remoteDataSource.getProducts()
            },
            mapToDomain = { dtos ->
                dtos.map { it.toDomain() }
            }
        )
    }
}