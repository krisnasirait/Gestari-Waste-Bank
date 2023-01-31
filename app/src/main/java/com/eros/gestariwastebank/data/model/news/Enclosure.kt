package com.eros.gestariwastebank.data.model.news


import com.google.gson.annotations.SerializedName

data class Enclosure(
    @SerializedName("length")
    val length: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)