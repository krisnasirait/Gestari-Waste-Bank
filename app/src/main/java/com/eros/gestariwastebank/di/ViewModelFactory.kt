package com.eros.gestariwastebank.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eros.gestariwastebank.data.local.LocalDataSource
import com.eros.gestariwastebank.data.remote.RemoteDataSource
import com.eros.gestariwastebank.data.remote.networking.ApiService
import com.eros.gestariwastebank.domain.Repository
import com.eros.gestariwastebank.domain.RepositoryImp
import com.eros.gestariwastebank.main.home.pricelist.ui.all.viewmodel.AllCatalogViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(modelClass) {
            AllCatalogViewModel::class.java -> AllCatalogViewModel(repository) as T
            else -> throw UnsupportedOperationException()
        }
    }

    companion object {

        private const val BASE_URL = "https://hammerhead-app-zfi4g.ondigitalocean.app/"

        private val logging : HttpLoggingInterceptor
            get() {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                return httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
            }

        private val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        private val remote : ApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(ApiService::class.java)
        }

        private val remoteDataSource = RemoteDataSource(remote)

        @Volatile
        private var INSTANCE : ViewModelFactory? = null
        fun getInstance(context : Context)= synchronized(ViewModelFactory::class.java){
            INSTANCE ?: ViewModelFactory(
                RepositoryImp(
                    remoteDataSource = remoteDataSource,
                    localDataSource = LocalDataSource()
                )
            ). also { INSTANCE = it }
        }
    }
}