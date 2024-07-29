package com.example.android3lesson5.data.remote.apiservice

import com.example.android3lesson5.data.remote.models.ResultsItem
import com.example.android3lesson5.data.remote.models.Titans
import retrofit2.Call
import retrofit2.http.GET

private const val TITAN = "titans/"

interface TitanApi {

    @GET(TITAN)
    fun getTitan():Call<Titans>
}