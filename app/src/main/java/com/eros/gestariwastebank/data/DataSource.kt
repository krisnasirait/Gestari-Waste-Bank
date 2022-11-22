package com.eros.gestariwastebank.data

import com.eros.gestariwastebank.data.model.catalog.CatalogResponse

interface DataSource {
    suspend fun getCatalog() : CatalogResponse
}