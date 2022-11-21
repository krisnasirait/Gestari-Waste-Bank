package com.eros.gestariwastebank.networking.response.login


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("address")
    val address: String?,
    @SerializedName("birthdate")
    val birthdate: String?,
    @SerializedName("birthplace")
    val birthplace: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("id_member")
    val idMember: String?,
    @SerializedName("id_number")
    val idNumber: String?,
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