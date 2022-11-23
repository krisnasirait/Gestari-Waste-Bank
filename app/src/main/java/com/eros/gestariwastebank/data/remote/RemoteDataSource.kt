package com.eros.gestariwastebank.data.remote

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import com.eros.gestariwastebank.data.model.login.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.ApiService
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest

class RemoteDataSource(
    private val apiService: ApiService
) : DataSource {
    override suspend fun getCatalog(): CatalogResponse {
        return apiService.getCatalog()
    }

    override suspend fun loginUser(loginRequest: LoginRequest): LoginResponse {
        return apiService.loginUser(loginRequest)
    }
}