package com.eros.gestariwastebank.data.remote.networking

import com.eros.gestariwastebank.data.remote.networking.response.CatalogResponse
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.NewsResponse
import com.eros.gestariwastebank.data.remote.networking.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    //user login
    @POST("user/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest) : Response<LoginResponse>

    //user register
    @POST("user/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest) : Response<RegisterResponse>

    //catalog
    @GET("/katalog")
    suspend fun getCatalog() : CatalogResponse

    //catalog kertas
    @GET("/katalog/type/kertas")
    suspend fun getCatalogPaper() : CatalogResponse

    //catalog plastik
    @GET("/katalog/type/plastik")
    suspend fun getCatalogPlastic() : CatalogResponse

    //catalog logam
    @GET("/katalog/type/logam")
    suspend fun getCatalogMetal() : CatalogResponse

    //catalog kaca
    @GET("/katalog/type/kaca")
    suspend fun getCatalogGlass() : CatalogResponse

    //catalog lainnya
    @GET("/katalog/type/khusus")
    suspend fun getCatalogOthers() : CatalogResponse

    //news
    @GET("top-headlines")
    suspend fun getNews(
        @Query("category") category: String,
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ) : NewsResponse



}