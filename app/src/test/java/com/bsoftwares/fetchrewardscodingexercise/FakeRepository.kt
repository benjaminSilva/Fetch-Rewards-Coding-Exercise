package com.bsoftwares.fetchrewardscodingexercise

import com.bsoftwares.fetchrewardscodingexercise.repo.RepositoryInterface
import com.bsoftwares.fetchrewardscodingexercise.utils.dummyList
import kotlinx.coroutines.flow.flow

class FakeRepository : RepositoryInterface {
    override suspend fun getData() = flow{
        emit(dummyList())
    }
}