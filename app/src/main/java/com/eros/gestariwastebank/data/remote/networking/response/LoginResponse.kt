package com.eros.gestariwastebank.data.remote.networking.response


import com.eros.gestariwastebank.data.model.login.Login
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val login: Login?,
    @SerializedName("status")
    val status: String?
)