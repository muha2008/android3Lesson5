package com.example.android3lesson5.data.repositories

import com.example.android3lesson5.data.RetrofitClient
import com.example.android3lesson5.data.remote.models.ResultsItem
import com.example.android3lesson5.data.remote.models.Titans
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TitanRepository {

    private val characterApi = RetrofitClient.titanResponse

    fun fetchTitan(
        onResponse: (titan: List<ResultsItem>) -> Unit,
        onFailure: (t: Throwable) -> Unit,
    ) {
        characterApi.getTitan().enqueue(object : Callback<Titans> {
            override fun onResponse(call: Call<Titans>, response: Response<Titans>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()!!.results?.let { onResponse(it) }
                }

            }

            override fun onFailure(call: Call<Titans>, t: Throwable) {
                onFailure(t)
            }
        })
    }
}