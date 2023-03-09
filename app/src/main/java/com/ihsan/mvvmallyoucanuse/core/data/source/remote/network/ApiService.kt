package com.ihsan.mvvmallyoucanuse.core.data.source.remote.network


import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.LoginRequest
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.RegisterRequest
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.request.UpdateProfileRequest
import com.ihsan.mvvmallyoucanuse.core.data.source.remote.response.LoginResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body login: LoginRequest,
//    @Field("email")email:String,
//    @Field("password")password:String
    ):Response<LoginResponse>

    @POST("register")
    suspend fun register(
        @Body data: RegisterRequest
    ):Response<LoginResponse>

    @PUT("update-user/{id}")
    suspend fun updateUser(
        @Path ("id") int: Int,
        @Body data: UpdateProfileRequest
    ):Response<LoginResponse>

    @Multipart
    @POST("upload-user/{id}")
    suspend fun uploadUser(
        @Path ("id") int: Int? = null,
        @Part data: MultipartBody.Part? = null
    ):Response<LoginResponse>
}