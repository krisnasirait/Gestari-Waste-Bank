package com.eros.gestariwastebank.data.remote

import com.eros.gestariwastebank.networking.request.LoginRequest
import com.eros.gestariwastebank.networking.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("user/login")
    fun loginUser(@Body loginRequest: LoginRequest): retrofit2.Call<LoginResponse>

}