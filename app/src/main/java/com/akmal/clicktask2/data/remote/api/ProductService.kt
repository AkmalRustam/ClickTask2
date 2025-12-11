package com.akmal.clicktask2.data.remote.api

import com.akmal.clicktask2.data.local.constant.LocalConstant.PRODUCTS
import com.akmal.clicktask2.data.remote.model.main.ProductDto
import retrofit2.http.GET

interface ProductService {
    @GET(PRODUCTS)
    suspend fun getProducts(): List<ProductDto>
}