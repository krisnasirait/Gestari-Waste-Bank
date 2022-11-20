package com.eros.gestariwastebank.networking.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: String?
)