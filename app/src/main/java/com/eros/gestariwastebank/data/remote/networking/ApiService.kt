package com.eros.gestariwastebank.data.remote.networking

import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("user/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest) : Response<LoginResponse>

    @POST("user/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest) : Response<RegisterResponse>

    @GET("/katalog")
    suspend fun getCatalog() : CatalogResponse

    @GET("/katalog/type/kertas")
    suspend fun getCatalogPaper() : CatalogResponse

    @GET("/katalog/type/plastik")
    suspend fun getCatalogPlastic() : CatalogResponse

    @GET("/katalog/type/logam")
    suspend fun getCatalogMetal() : CatalogResponse

    @GET("/katalog/type/kaca")
    suspend fun getCatalogGlass() : CatalogResponse

    @GET("/katalog/type/khusus")
    suspend fun getCatalogOthers() : CatalogResponse



}