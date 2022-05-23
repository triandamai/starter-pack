package com.trian.module.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trian.domain.models.response.TodoResponse
import com.trian.domain.utils.network.DataState
import com.trian.module.repository.design.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Main ViewModel Class
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 28/08/2021
 */
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private var _listTodos = MutableLiveData<DataState<List<TodoResponse>>>()
    val listTodos get() = _listTodos

    init {
        getTodo()
    }
    fun getTodo()=viewModelScope.launch {
        mainRepository.getTodos()
            .onEach {
                _listTodos.postValue(it)
            }.collect()
    }

}