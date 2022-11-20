package com.eros.gestariwastebank.networking.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("accessToken")
    val accessToken: String?,
    @SerializedName("user")
    val user: User?
)