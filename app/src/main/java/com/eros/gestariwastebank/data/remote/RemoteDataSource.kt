package com.eros.gestariwastebank.data.remote

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.ApiService

class RemoteDataSource(
    private val apiService: ApiService
) : DataSource {
    override suspend fun getCatalog(): CatalogResponse {
        return apiService.getCatalog()
    }
}