package com.akmal.clicktask2.data.remote.mapper

import com.akmal.clicktask2.data.remote.model.main.ProductDto
import com.akmal.clicktask2.data.remote.model.main.RatingDto
import com.akmal.clicktask2.domain.model.main.Product
import com.akmal.clicktask2.domain.model.main.Rating

fun ProductDto.toDomain(): Product = Product(
    this.category,
    this.description,
    this.id,
    this.image,
    this.price,
    this.rating.toDomain(),
    this.title
)

fun RatingDto.toDomain(): Rating = Rating(
    this.count,
    this.rate
)