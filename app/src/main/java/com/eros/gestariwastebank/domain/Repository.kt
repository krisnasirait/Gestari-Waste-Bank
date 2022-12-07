package com.eros.gestariwastebank.domain

import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.NewsResponse
import com.eros.gestariwastebank.data.remote.networking.response.RegisterResponse
import retrofit2.Response

interface Repository {

    suspend fun getCatalog() : CatalogResponse

    suspend fun getCatalogPaper() : CatalogResponse

    suspend fun getCatalogPlastic() : CatalogResponse

    suspend fun getCatalogMetal() : CatalogResponse

    suspend fun getCatalogGlass() : CatalogResponse

    suspend fun getCatalogOthers() : CatalogResponse

    suspend fun loginUser(loginRequest: LoginRequest) : Response<LoginResponse>

    suspend fun registerUser(registerRequest: RegisterRequest) : Response<RegisterResponse>

    suspend fun getNews(
        category: String,
        country: String,
        apiKey: String
    ): NewsResponse
}