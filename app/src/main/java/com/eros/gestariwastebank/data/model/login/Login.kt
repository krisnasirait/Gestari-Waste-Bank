package com.eros.gestariwastebank.data.model.login


import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("accessToken")
    val accessToken: String?,
    @SerializedName("user")
    val user: User?
)