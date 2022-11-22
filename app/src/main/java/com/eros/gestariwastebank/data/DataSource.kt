package com.eros.gestariwastebank.data

import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import retrofit2.http.Body

interface DataSource {
    suspend fun getCatalog() : CatalogResponse
}