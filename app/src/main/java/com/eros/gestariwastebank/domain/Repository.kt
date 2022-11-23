package com.eros.gestariwastebank.domain

import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import com.eros.gestariwastebank.data.model.login.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest

interface Repository {
    suspend fun getCatalog() : CatalogResponse
    suspend fun loginUser(loginRequest: LoginRequest) : LoginResponse
}