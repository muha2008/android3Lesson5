package com.example.android3lesson5.data.remote.models

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("next_page")
    val nextPage:String?,
    @SerializedName("pages")
    val pages: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("prev_page")
    val prevPage:String?
)