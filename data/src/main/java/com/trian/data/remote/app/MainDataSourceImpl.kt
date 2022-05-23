package com.trian.data.remote.app

import com.trian.data.remote.app.design.MainDataSource
import com.trian.data.remote.app.services.MainApiServices
import com.trian.data.utils.safeApiCall
import com.trian.domain.models.response.BaseResponse
import com.trian.domain.models.response.TodoResponse
import com.trian.domain.utils.network.DataState


class MainDataSourceImpl(
    private val apiServices: MainApiServices
): MainDataSource {
    override suspend fun getTodos(
        page: Int,
        size: Int
    )= safeApiCall { apiServices.getTodos(page,size) }


}