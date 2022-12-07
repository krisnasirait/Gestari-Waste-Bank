package com.eros.gestariwastebank.data.local

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.NewsResponse
import com.eros.gestariwastebank.data.remote.networking.response.RegisterResponse
import retrofit2.Response

class LocalDataSource : DataSource {
    override suspend fun getCatalog(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogPaper(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogPlastic(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogMetal(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogGlass(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogOthers(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getNews(category: String, country: String, apiKey: String): NewsResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }
}