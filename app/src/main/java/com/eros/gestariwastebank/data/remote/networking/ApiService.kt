package com.eros.gestariwastebank.data.remote.networking

import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.model.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("user/login")
    fun loginUser(@Body loginRequest: LoginRequest): retrofit2.Call<LoginResponse>

//    @GET("/katalog")

}