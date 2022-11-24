package com.eros.gestariwastebank.data.remote.networking.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("name") var name: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("birthdate") var birthdate: String? = null,
    @SerializedName("birthplace") var birthplace: String? = null,
    @SerializedName("NIK") var nik: String? = null,
    @SerializedName("password") var password: String? = null
)