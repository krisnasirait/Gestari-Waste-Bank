package com.eros.gestariwastebank.domain

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import com.eros.gestariwastebank.data.model.login.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import retrofit2.Response

class RepositoryImp(
    private val localDataSource: DataSource,
    private val remoteDataSource: DataSource
) : Repository {

    override suspend fun getCatalog(): CatalogResponse {
        return remoteDataSource.getCatalog()
    }

    override suspend fun getCatalogPaper(): CatalogResponse {
        return remoteDataSource.getCatalogPaper()
    }

    override suspend fun getCatalogPlastic(): CatalogResponse {
        return remoteDataSource.getCatalogPlastic()
    }

    override suspend fun getCatalogMetal(): CatalogResponse {
        return remoteDataSource.getCatalogMetal()
    }

    override suspend fun getCatalogGlass(): CatalogResponse {
        return remoteDataSource.getCatalogGlass()
    }

    override suspend fun getCatalogOthers(): CatalogResponse {
        return remoteDataSource.getCatalogOthers()
    }

    override suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        return remoteDataSource.loginUser(loginRequest)
    }

}