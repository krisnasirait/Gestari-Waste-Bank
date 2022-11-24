package com.eros.gestariwastebank.data.model.register


import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("address")
    val address: String?,
    @SerializedName("balance")
    val balance: Int?,
    @SerializedName("birthdate")
    val birthdate: String?,
    @SerializedName("birthplace")
    val birthplace: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("NIK")
    val nIK: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)