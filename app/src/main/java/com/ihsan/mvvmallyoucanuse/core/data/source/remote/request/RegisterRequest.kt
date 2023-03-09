package com.ihsan.mvvmallyoucanuse.core.data.source.remote.request

data class RegisterRequest(
    val name: String,
    val email:String,
    val nis:String,
    val password:String
)