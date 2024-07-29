package com.example.android3lesson5.data.remote.models

import com.google.gson.annotations.SerializedName

data class Titans(
    @SerializedName("results")
    val results: List<ResultsItem>?,
    @SerializedName("info")
    val info: Info
)