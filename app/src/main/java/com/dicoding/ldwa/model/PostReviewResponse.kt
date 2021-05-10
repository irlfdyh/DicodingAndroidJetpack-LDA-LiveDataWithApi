package com.dicoding.ldwa.model

import com.google.gson.annotations.SerializedName

data class PostReviewResponse(
    @field:SerializedName("customerReviews")
    val customerReviews: List<CustomerReviewItems>,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)
