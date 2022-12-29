package com.eros.gestariwastebank.data

import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.NewsResponse
import com.eros.gestariwastebank.data.remote.networking.response.RegisterResponse
import retrofit2.Response

interface DataSource {

    suspend fun getCatalog() : CatalogResponse

    suspend fun getCatalogPaper() : CatalogResponse

    suspend fun getCatalogPlastic() : CatalogResponse

    suspend fun getCatalogMetal() : CatalogResponse

    suspend fun getCatalogGlass() : CatalogResponse

    suspend fun getCatalogOthers() : CatalogResponse

    suspend fun loginUser(loginRequest: LoginRequest) : Response<LoginResponse>

    suspend fun registerUser(registerRequest: RegisterRequest) : Response<RegisterResponse>

    suspend fun getNews(): NewsResponse

    suspend fun getCart(): List<Cart>

    suspend fun insertCart(
        cart: Cart
    )

    suspend fun updateCart(
        cart: Cart
    )

    suspend fun deleteCart(
        cart: Cart
    )

    suspend fun addOrInsertCartById(
        id: Int, name: String, itemImage: String, amount: Int, price: Int
    )

}