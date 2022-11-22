package com.eros.gestariwastebank.domain

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse

class RepositoryImp(
    private val localDataSource: DataSource,
    private val remoteDataSource: DataSource
) : Repository {
    override suspend fun getCatalog(): CatalogResponse {
        return remoteDataSource.getCatalog()
    }

}