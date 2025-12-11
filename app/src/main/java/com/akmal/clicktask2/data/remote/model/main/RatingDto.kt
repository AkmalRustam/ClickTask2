package com.akmal.clicktask2.data.remote.model.main

import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("count") val count: Int,
    @SerializedName("rate") val rate: Double
)