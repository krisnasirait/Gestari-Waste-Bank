package com.eros.gestariwastebank.main.auth.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.eros.gestariwastebank.data.helpers.SharedPreferenceHelper
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginViewModel(
    private val repository: Repository,
    context: Context
) : ViewModel() {
    private val sharedPreferenceHelper = SharedPreferenceHelper(context.applicationContext)

    private val _login = MutableLiveData<LoginResponse?>()
    val login: LiveData<LoginResponse?> = _login

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _isLoading = MutableLiveData<String>()
    val isLoading: LiveData<String> = _isLoading

    private suspend fun requestLogin(loginRequest: LoginRequest): Response<LoginResponse> {
        return repository.loginUser(loginRequest)
    }

    fun getLogin(loginRequest: LoginRequest): MutableLiveData<LoginResponse?> {
        viewModelScope.launch {
            kotlin.runCatching {
                _isLoading.value = "loading"
                withContext(Dispatchers.IO) {
                    requestLogin(loginRequest)
                }
            }.onSuccess { response ->
                withContext(Dispatchers.Main) {
                    _login.value = response.body()
                    _isLoading.value = "done"
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                    _isLoading.value = "error"
                }
            }
        }
        return _login
    }

    //create function to check if form is valid or not in LoginActivity.kt file
    fun isFormValid(
        email: String,
        password: String
    ): Boolean {
        return when {
            email.isEmpty() -> {
                _errorMessage.value = "Email tidak boleh kosong"
                false
            }
            password.isEmpty() -> {
                _errorMessage.value = "Password tidak boleh kosong"
                false
            }
            else -> true
        }
    }

    fun saveCredentials(email: String, password: String) {
        sharedPreferenceHelper.saveCredentials(email, password)
    }

    fun getEmail(): String? {
        return sharedPreferenceHelper.getEmail()
    }

    fun getPassword(): String? {
        return sharedPreferenceHelper.getPassword()
    }

    fun clearCredentials() {
        sharedPreferenceHelper.clearCreds()
    }

}