package com.trian.module.repository

import com.trian.data.coroutines.DispatcherProvider
import com.trian.data.local.Persistence
import com.trian.data.local.room.AppSettingDao
import com.trian.data.remote.app.design.MainDataSource
import com.trian.domain.models.response.TodoResponse
import com.trian.domain.utils.network.DataState
import com.trian.module.repository.design.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Persistence Class
 * Author PT Cexup Telemedicine
 * Created by Trian Damai
 * 01/09/2021
 */

class MainRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val persistence: Persistence,
    private val mainDataSource: MainDataSource,
    private val appSettingDao: AppSettingDao
) : MainRepository {
    override suspend fun getTodos()= flow {
        emit(DataState.onLoading)
        when(val result =mainDataSource.getTodos(1,10) ){
            is DataState.onData -> {
                if(result.data.code in 200..209){
                    emit(DataState.onData(result.data.data))
                }else{
                    emit(DataState.onFailure(result.data.message))
                }
            }
            is DataState.onFailure -> emit(result)
            DataState.onLoading -> emit(DataState.onLoading)
        }
    }


}