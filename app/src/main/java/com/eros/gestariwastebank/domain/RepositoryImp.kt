package com.eros.gestariwastebank.domain

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import com.eros.gestariwastebank.data.model.login.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest

class RepositoryImp(
    private val localDataSource: DataSource,
    private val remoteDataSource: DataSource
) : Repository {

    override suspend fun getCatalog(): CatalogResponse {
        return remoteDataSource.getCatalog()
    }

    override suspend fun loginUser(loginRequest: LoginRequest): LoginResponse {
        return remoteDataSource.loginUser(loginRequest)
    }

}