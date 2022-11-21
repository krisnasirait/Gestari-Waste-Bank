package com.eros.gestariwastebank.networking.response.katalog


import com.google.gson.annotations.SerializedName

data class CatalogResponse(
    @SerializedName("data")
    val `data`: List<Catalog?>?,
    @SerializedName("status")
    val status: String?
)