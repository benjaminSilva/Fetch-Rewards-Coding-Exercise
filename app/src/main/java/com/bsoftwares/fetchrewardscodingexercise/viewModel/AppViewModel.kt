package com.bsoftwares.fetchrewardscodingexercise.viewModel

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoftwares.fetchrewardscodingexercise.model.Data
import com.bsoftwares.fetchrewardscodingexercise.repo.Repository
import com.bsoftwares.fetchrewardscodingexercise.repo.RepositoryInterface
import com.bsoftwares.fetchrewardscodingexercise.utils.dummyList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor(private val repository: RepositoryInterface) : ViewModel() {

    private val _data = MutableLiveData<List<Data>>()
    val data: LiveData<List<Data>>
        get() = _data

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getData().collect {
                _data.postValue(organizeList(it))
            }
        }
    }

    private fun organizeList(list: List<Data>): List<Data> {
        return list.sortedWith(compareBy({it.listId},{it.id}))
    }

}