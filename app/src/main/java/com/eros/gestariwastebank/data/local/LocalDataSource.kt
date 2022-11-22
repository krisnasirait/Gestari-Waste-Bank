package com.eros.gestariwastebank.data.local

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse

class LocalDataSource : DataSource {
    override suspend fun getCatalog(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }
}