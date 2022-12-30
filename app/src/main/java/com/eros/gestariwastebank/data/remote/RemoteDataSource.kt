package com.eros.gestariwastebank.data.remote

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.ApiService
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.NewsResponse
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

    override suspend fun getNews(): NewsResponse {
        return apiNewsService.getNews()
    }

    override suspend fun getCart(): List<Cart> {
        throw UnsupportedOperationException("Use Local Data Source!")
    }

    override suspend fun insertCart(cart: Cart) {
        throw UnsupportedOperationException("Use Local Data Source!")
    }

    override suspend fun updateCart(cart: Cart) {
        throw UnsupportedOperationException("Use Local Data Source!")
    }

    override suspend fun deleteCart(cart: Cart) {
        throw UnsupportedOperationException("Use Local Data Source!")
    }

    override suspend fun addOrInsertCartById(
        id: Int, name: String, itemImage: String, amount: Int, price: Int
    ) {
        throw UnsupportedOperationException("Use Local Data Source!")
    }

    override suspend fun getRowCount(): Int {
        throw UnsupportedOperationException("Use Local Data Source!")
    }

    override suspend fun decrementQuantity(productId: Int) {
        throw UnsupportedOperationException("Use Local Data Source!")
    }

    override suspend fun incrementQuantity(productId: Int) {
        throw UnsupportedOperationException("Use Local Data Source!")
    }


}