package com.akmal.clicktask2.data.remote.model.main

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("category") val category: String,
    @SerializedName("description") val description: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("price") val price: Double,
    @SerializedName("rating") val rating: RatingDto,
    @SerializedName("title") val title: String
)