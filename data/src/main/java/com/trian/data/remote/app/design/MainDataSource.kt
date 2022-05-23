package com.trian.data.remote.app.design

import com.trian.domain.models.response.BaseResponse
import com.trian.domain.models.response.TodoResponse
import com.trian.domain.utils.network.DataState


interface MainDataSource {
    suspend fun getTodos(
        page:Int,
        size:Int
    ):DataState<BaseResponse<List<TodoResponse>>>
}
