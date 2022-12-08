package com.eros.gestariwastebank.main.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
import com.eros.gestariwastebank.data.remote.networking.response.RegisterResponse
import com.eros.gestariwastebank.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class RegisterViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _register = MutableLiveData<RegisterResponse?>()

    private val _errorMessage = MutableLiveData<String>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private suspend fun requestRegister(registerRequest: RegisterRequest) : Response<RegisterResponse> {
        return repository.registerUser(registerRequest)
    }

    fun getRegister(registerRequest: RegisterRequest) : MutableLiveData<RegisterResponse?> {
        viewModelScope.launch {
            kotlin.runCatching {
                _isLoading.value = true
                withContext(Dispatchers.IO) {
                    requestRegister(registerRequest)
                }
            }.onSuccess { response ->
                withContext(Dispatchers.Main) {
                    _register.value = response.body()
                    _isLoading.value = false
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                    _isLoading.value = false
                }
            }
        }
        return _register
    }

}