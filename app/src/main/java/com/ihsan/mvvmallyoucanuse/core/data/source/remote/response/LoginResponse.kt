package com.ihsan.mvvmallyoucanuse.core.data.source.remote.response

import com.ihsan.mvvmallyoucanuse.core.data.source.model.User


data class LoginResponse(
    val code : Int? = null,
    val message : String? = null,
    val data : User? = null
)