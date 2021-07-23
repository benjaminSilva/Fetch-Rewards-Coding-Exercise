package com.bsoftwares.fetchrewardscodingexercise.network

import com.bsoftwares.fetchrewardscodingexercise.model.Data
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface FetchApi {
    @GET("hiring.json")
    fun getData() : Deferred<List<Data>>
}