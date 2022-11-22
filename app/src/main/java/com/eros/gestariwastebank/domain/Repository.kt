package com.eros.gestariwastebank.domain

import com.eros.gestariwastebank.data.model.catalog.CatalogResponse

interface Repository {
    suspend fun getCatalog() : CatalogResponse
}