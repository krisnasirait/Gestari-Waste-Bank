package com.eros.gestariwastebank.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object ApiClient {
    private const val BASE_URL = "https://hammerhead-app-zfi4g.ondigitalocean.app/"

    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}