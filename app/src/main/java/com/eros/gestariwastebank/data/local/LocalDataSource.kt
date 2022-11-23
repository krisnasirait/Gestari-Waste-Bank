package com.eros.gestariwastebank.data.local

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import com.eros.gestariwastebank.data.model.login.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
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
}