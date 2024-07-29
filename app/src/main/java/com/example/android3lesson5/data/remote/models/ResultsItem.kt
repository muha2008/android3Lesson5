package com.example.android3lesson5.data.remote.models

import com.google.gson.annotations.SerializedName

data class ResultsItem(
    @SerializedName("abilities")
    val abilities: List<String>?,
    @SerializedName("current_inheritor")
    val currentInheritor: String = "",
    @SerializedName("img")
    val img: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("former_inheritors")
    val formerInheritors: List<String>?,
    @SerializedName("allegiance")
    val allegiance: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("height")
    val height: String = ""
)