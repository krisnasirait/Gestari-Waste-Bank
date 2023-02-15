package com.eros.gestariwastebank.main.auth.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eros.gestariwastebank.data.helpers.SharedPreferenceHelper
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginViewModel(
    private val repository: Repository,
    context: Context
) : ViewModel() {
    private val sharedPreferenceHelper = SharedPreferenceHelper(context.applicationContext)

    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState> = _state

    private suspend fun requestLogin(loginRequest: LoginRequest): Response<LoginResponse> {
        return repository.loginUser(loginRequest)
    }

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                _state.value = LoginState.Loading
                withContext(Dispatchers.IO) {
                    requestLogin(loginRequest)
                }
            }.onSuccess { response ->
                withContext(Dispatchers.Main) {
                    _state.value = LoginState.Success(response.body())
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _state.value = LoginState.Error(error.message)
                }
            }
        }
    }

    fun isFormValid(
        email: String,
        password: String
    ): Boolean {
        return when {
            email.isEmpty() && password.isEmpty() -> {
                _state.value = LoginState.Error("Email dan Password tidak boleh kosong")
                false
            }
            email.isEmpty() -> {
                _state.value = LoginState.Error("Email tidak boleh kosong")
                false
            }
            "@" !in email -> {
                _state.value = LoginState.Error("Email tidak valid")
                false
            }
            password.isEmpty() -> {
                _state.value = LoginState.Error("Password tidak boleh kosong")
                false
            }
            password.length < 8 -> {
                _state.value = LoginState.Error("Password tidak boleh kurang dari 8 huruf")
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

sealed class LoginState {
    object Loading : LoginState()
    data class Success(val response: LoginResponse?) : LoginState()
    data class Error(val message: String?) : LoginState()
}