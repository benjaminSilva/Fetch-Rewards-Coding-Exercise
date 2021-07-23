package com.bsoftwares.fetchrewardscodingexercise.repo

import com.bsoftwares.fetchrewardscodingexercise.model.Data
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    suspend fun getData() : Flow<List<Data>>
}