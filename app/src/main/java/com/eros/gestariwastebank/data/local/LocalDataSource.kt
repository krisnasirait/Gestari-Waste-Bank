package com.eros.gestariwastebank.data.local

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import com.eros.gestariwastebank.data.model.login.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest

class LocalDataSource : DataSource {
    override suspend fun getCatalog(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun loginUser(loginRequest: LoginRequest): LoginResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }
}