package com.eros.gestariwastebank.data.remote.networking.response


import com.eros.gestariwastebank.data.model.news.Article
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article?>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)