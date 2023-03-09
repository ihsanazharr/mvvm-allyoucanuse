package com.ihsan.mvvmallyoucanuse.core.data.source.remote.request

data class UpdateProfileRequest(
    val id: Int,
    val name: String? = null,
    val email: String? = null,
    val nis: String? = null


)