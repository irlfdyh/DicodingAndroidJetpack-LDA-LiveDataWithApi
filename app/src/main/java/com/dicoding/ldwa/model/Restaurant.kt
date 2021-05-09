package com.dicoding.ldwa.model

import com.google.gson.annotations.SerializedName

data class Restaurant(
    @field:SerializedName("customerReviews")
    val customerReviews: List<CustomerReviewItems>,

    @field:SerializedName("pictureId")
    val pictureId: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("id")
    val id: String
)
