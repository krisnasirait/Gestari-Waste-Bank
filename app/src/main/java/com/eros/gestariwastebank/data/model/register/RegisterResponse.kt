package com.eros.gestariwastebank.data.model.register


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("data")
    val register: Register?,
    @SerializedName("status")
    val status: String?
)