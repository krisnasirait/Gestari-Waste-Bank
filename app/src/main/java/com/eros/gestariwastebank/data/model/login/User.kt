package com.eros.gestariwastebank.data.model.login


import com.google.gson.annotations.SerializedName

data class User(
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
    @SerializedName("gender")
    val gender: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("id_member")
    val idMember: String?,
    @SerializedName("NIK")
    val nIK: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("profile_picture")
    val profilePicture: Any?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)