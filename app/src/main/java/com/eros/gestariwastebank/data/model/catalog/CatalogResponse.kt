package com.eros.gestariwastebank.data.model.catalog


import com.google.gson.annotations.SerializedName

data class CatalogResponse(
    @SerializedName("data")
    val `data`: List<Catalog?>?,
    @SerializedName("status")
    val status: String?
)