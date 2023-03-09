package com.ihsan.mvvmallyoucanuse.core.data.source.remote

import com.ihsan.mvvmallyoucanuse.core.data.source.remote.network.ApiService
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.LoginRequest
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.RegisterRequest
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.UpdateProfileRequest
import okhttp3.MultipartBody

class RemoteDataSource(private val api: ApiService) {

    suspend fun login(data: LoginRequest) = api.login(data)
    suspend fun register(data: RegisterRequest) = api.register(data)
    suspend fun updateUser(data: UpdateProfileRequest) = api.updateUser(data.id, data)
    suspend fun uploadUser(id: Int? = null, fileImage : MultipartBody.Part? = null) = api.uploadUser(id, fileImage)
}