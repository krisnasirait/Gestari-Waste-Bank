package com.eros.gestariwastebank.data.local

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.local.room.CartDatabase
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.NewsResponse
import com.eros.gestariwastebank.data.remote.networking.response.RegisterResponse
import retrofit2.Response

class LocalDataSource(
    private val cartDatabase: CartDatabase
) : DataSource {
    override suspend fun getCatalog(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogPaper(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogPlastic(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogMetal(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogGlass(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCatalogOthers(): CatalogResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse> {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getNews(): NewsResponse {
        throw UnsupportedOperationException("Use Remote Data Source!")
    }

    override suspend fun getCart(): List<Cart> {
        return cartDatabase.cartDao().getAll()
    }

    override suspend fun insertCart(cart: Cart) {
        return cartDatabase.cartDao().insert(cart)
    }

    override suspend fun updateCart(cart: Cart) {
        return cartDatabase.cartDao().update(cart)
    }

    override suspend fun deleteCart(cart: Cart) {
        return cartDatabase.cartDao().delete(cart)
    }

    override suspend fun addOrInsertCartById(
        id: Int, name: String, itemImage: String, amount: Int, price: Int
    ) {
        return cartDatabase.cartDao().addOrInsertById(id, name, itemImage, amount, price)
    }

    override suspend fun getRowCount(): Int {
        return cartDatabase.cartDao().getRowCount()
    }

    override suspend fun decrementQuantity(productId: Int) {
        return cartDatabase.cartDao().decrementQuantity(productId)
    }

    override suspend fun incrementQuantity(productId: Int) {
        return cartDatabase.cartDao().incrementQuantity(productId)
    }


}