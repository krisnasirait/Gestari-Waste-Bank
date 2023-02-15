package com.eros.gestariwastebank.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eros.gestariwastebank.data.remote.RemoteDataSource
import com.eros.gestariwastebank.data.remote.networking.ApiService
import com.eros.gestariwastebank.domain.Repository
import com.eros.gestariwastebank.domain.RepositoryImp
import com.eros.gestariwastebank.main.auth.viewmodel.LoginViewModel
import com.eros.gestariwastebank.main.auth.viewmodel.RegisterViewModel
import com.eros.gestariwastebank.main.home.artikel.viewmodel.NewsViewModel
import com.eros.gestariwastebank.main.home.pricelist.viewmodel.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: Repository,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repository::class.java, Context::class.java)
            .newInstance(repository, context)
    }

    companion object {

        private const val BASE_URL = "https://hammerhead-app-zfi4g.ondigitalocean.app/"
        private const val NEWS_URL = "https://berita-indo-api.vercel.app/v1/"

        private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        private val gsonConverterFactory: GsonConverterFactory = GsonConverterFactory.create()

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()

        private val remote: ApiService = retrofit.create(ApiService::class.java)

        // Use the same retrofit instance for both API endpoints
        private val remoteNews: ApiService = Retrofit.Builder()
            .baseUrl(NEWS_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(ApiService::class.java)

        private val remoteDataSource = RemoteDataSource(remote, remoteNews)

        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(context: Context) = synchronized(ViewModelFactory::class.java) {
            INSTANCE ?: ViewModelFactory(
                RepositoryImp(
                    remoteDataSource = remoteDataSource
                ),
                context
            ).also { INSTANCE = it }
        }
    }

}