package com.eros.gestariwastebank.networking.response.katalog


import com.google.gson.annotations.SerializedName

data class Catalog(
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("kode_katalog")
    val kodeKatalog: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("satuan")
    val satuan: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)