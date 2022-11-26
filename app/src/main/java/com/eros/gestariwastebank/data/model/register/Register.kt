package com.eros.gestariwastebank.data.model.register


import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("address")
    val address: Any?,
    @SerializedName("balance")
    val balance: Any?,
    @SerializedName("birthdate")
    val birthdate: Any?,
    @SerializedName("birthplace")
    val birthplace: Any?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("gender")
    val gender: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("id_member")
    val idMember: Any?,
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