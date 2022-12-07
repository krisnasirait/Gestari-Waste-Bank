package com.eros.gestariwastebank.data.remote

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.ApiService
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.RegisterResponse
import retrofit2.Response

class RemoteDataSource(
    private val apiService: ApiService,
    private val apiNewsService : ApiService
) : DataSource {
    override suspend fun getCatalog(): CatalogResponse {
        return apiService.getCatalog()
    }

    override suspend fun getCatalogPaper(): CatalogResponse {
        return apiService.getCatalogPaper()
    }

    override suspend fun getCatalogPlastic(): CatalogResponse {
        return apiService.getCatalogPlastic()
    }

    override suspend fun getCatalogMetal(): CatalogResponse {
        return apiService.getCatalogMetal()
    }

    override suspend fun getCatalogGlass(): CatalogResponse {
        return apiService.getCatalogGlass()
    }

    override suspend fun getCatalogOthers(): CatalogResponse {
        return apiService.getCatalogOthers()
    }

    override suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        return apiService.loginUser(loginRequest)
    }

    override suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        return apiService.registerUser(registerRequest)
    }
}