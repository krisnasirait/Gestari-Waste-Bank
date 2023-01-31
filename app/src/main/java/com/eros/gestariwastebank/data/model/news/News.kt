package com.eros.gestariwastebank.data.model.news


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("content:encoded")
    val contentEncoded: String?,
    @SerializedName("content:encodedSnippet")
    val contentEncodedSnippet: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("enclosure")
    val enclosure: Enclosure?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("isoDate")
    val isoDate: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("title")
    val title: String?
)