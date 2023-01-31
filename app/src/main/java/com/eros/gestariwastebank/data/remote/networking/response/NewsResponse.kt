package com.eros.gestariwastebank.data.remote.networking.response


import com.eros.gestariwastebank.data.model.news.News
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val `data`: List<News?>?,
    @SerializedName("messages")
    val messages: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?
)