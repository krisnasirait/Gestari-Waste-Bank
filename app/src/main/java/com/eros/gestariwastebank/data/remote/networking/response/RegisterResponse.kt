package com.eros.gestariwastebank.data.remote.networking.response


import com.eros.gestariwastebank.data.model.register.Register
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("data")
    val register: Register?,
    @SerializedName("status")
    val status: String?
)