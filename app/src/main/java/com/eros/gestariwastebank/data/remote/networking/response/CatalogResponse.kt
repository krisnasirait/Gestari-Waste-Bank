package com.eros.gestariwastebank.data.remote.networking.response


import com.eros.gestariwastebank.data.model.catalog.Catalog
import com.google.gson.annotations.SerializedName

data class CatalogResponse(
    @SerializedName("data")
    val result: List<Catalog?>?,
    @SerializedName("status")
    val status: String?
)