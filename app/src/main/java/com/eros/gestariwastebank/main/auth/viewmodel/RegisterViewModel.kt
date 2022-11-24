package com.eros.gestariwastebank.main.auth.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eros.gestariwastebank.data.model.register.RegisterResponse
import com.eros.gestariwastebank.data.remote.networking.request.RegisterRequest
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

    private suspend fun requestRegister(registerRequest: RegisterRequest) : Response<RegisterResponse> {
        return repository.registerUser(registerRequest)
    }

    fun getRegister(registerRequest: RegisterRequest) : MutableLiveData<RegisterResponse?> {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    requestRegister(registerRequest)
                }
            }.onSuccess { response ->
                withContext(Dispatchers.Main) {
                    _register.value = response.body()
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                }
            }
        }
        return _register
    }

}