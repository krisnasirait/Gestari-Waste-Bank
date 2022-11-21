package com.eros.gestariwastebank.networking.response.login


import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("accessToken")
    val accessToken: String?,
    @SerializedName("user")
    val user: User?
)