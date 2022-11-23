package com.eros.gestariwastebank.data.model.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val result: Login?,
    @SerializedName("status")
    val status: String?
)