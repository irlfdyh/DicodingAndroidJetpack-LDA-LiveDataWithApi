package com.dicoding.ldwa.model

import com.google.gson.annotations.SerializedName

data class CustomerReviewItems(
    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("review")
    val review: String,

    @field:SerializedName("name")
    val name: String
)
