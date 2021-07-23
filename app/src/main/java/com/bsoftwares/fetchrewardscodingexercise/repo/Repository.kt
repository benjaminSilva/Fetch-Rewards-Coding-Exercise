package com.bsoftwares.fetchrewardscodingexercise.repo

import android.util.Log
import com.bsoftwares.fetchrewardscodingexercise.model.Data
import com.bsoftwares.fetchrewardscodingexercise.network.FetchApi
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(private val fetchApi : FetchApi) : RepositoryInterface {

    override suspend fun getData() = flow {
        try {
            emit(fetchApi.getData().await())
        } catch (t : Throwable){
            Log.e("Throwable",t.message.toString())
        }
    }
}