package com.eros.gestariwastebank.main.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eros.gestariwastebank.data.Util
import com.eros.gestariwastebank.data.model.news.Article
import com.eros.gestariwastebank.data.remote.networking.response.LoginResponse
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _login = MutableLiveData<LoginResponse?>()
    val login: LiveData<LoginResponse?> = _login

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private suspend fun requestLogin(loginRequest: LoginRequest): Response<LoginResponse> {
        return repository.loginUser(loginRequest)
    }

    fun getLogin(loginRequest: LoginRequest): MutableLiveData<LoginResponse?> {
        viewModelScope.launch {
            kotlin.runCatching {
                _isLoading.value = true
                withContext(Dispatchers.IO) {
                    requestLogin(loginRequest)
                }
            }.onSuccess { response ->
                withContext(Dispatchers.Main) {
                    _login.value = response.body()
                    _isLoading.value = false
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                    _isLoading.value = false
                }
            }
        }
        return _login
    }

}