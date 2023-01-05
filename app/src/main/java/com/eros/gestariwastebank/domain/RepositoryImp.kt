package com.eros.gestariwastebank.domain

import com.eros.gestariwastebank.data.DataSource
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.NewsResponse
import com.eros.gestariwastebank.data.remote.networking.response.RegisterResponse
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

    override suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        return remoteDataSource.registerUser(registerRequest)
    }

    override suspend fun getNews(): NewsResponse {
        return remoteDataSource.getNews()
    }

    override suspend fun getCart(): List<Cart> {
        return localDataSource.getCart()
    }

    override suspend fun insertCart(cart: Cart) {
        return localDataSource.insertCart(cart)
    }

    override suspend fun updateCart(cart: Cart) {
        return localDataSource.updateCart(cart)
    }

    override suspend fun deleteCart(item: Cart) {
        return localDataSource.deleteCart(item)
    }

    override suspend fun addOrInsertCartById(
        id: Int, name: String, itemImage: String, amount: Int, price: Int
    ) {
        return localDataSource.addOrInsertCartById(id, name, itemImage, amount, price)
    }

    override suspend fun getRowCount(): Int {
        return localDataSource.getRowCount()
    }

    override suspend fun decrementQuantity(id: Int) {
        return localDataSource.decrementQuantity(id)
    }

    override suspend fun incrementQuantity(id: Int) {
        return localDataSource.incrementQuantity(id)
    }

    override suspend fun getProductById(id: Int): Cart {
        return localDataSource.getProductById(id)
    }

    override suspend fun dropDatabase() {
        return localDataSource.dropDatabase()
    }
}