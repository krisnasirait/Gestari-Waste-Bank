package com.eros.gestariwastebank.data.model.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val login: Login?,
    @SerializedName("status")
    val status: String?
)