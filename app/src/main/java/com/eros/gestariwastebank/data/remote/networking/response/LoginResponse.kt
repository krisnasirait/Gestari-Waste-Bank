package com.eros.gestariwastebank.data.remote.networking.response


import com.eros.gestariwastebank.data.model.login.Data
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: String?
)