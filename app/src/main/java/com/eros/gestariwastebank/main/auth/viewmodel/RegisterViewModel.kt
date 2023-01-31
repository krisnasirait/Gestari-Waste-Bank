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

    private val _isLoading = MutableLiveData<String>()
    val isLoading: LiveData<String> = _isLoading

    private suspend fun requestRegister(registerRequest: RegisterRequest) : Response<RegisterResponse> {
        return repository.registerUser(registerRequest)
    }

    fun getRegister(registerRequest: RegisterRequest) : MutableLiveData<RegisterResponse?> {
        viewModelScope.launch {
            kotlin.runCatching {
                _isLoading.value = "loading"
                withContext(Dispatchers.IO) {
                    requestRegister(registerRequest)
                }
            }.onSuccess { response ->
                withContext(Dispatchers.Main) {
                    _register.value = response.body()
                    _isLoading.value = "done"
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                    _isLoading.value = "error"
                }
            }
        }
        return _register
    }

    fun isFormValid(
        name: String,
        phone: String,
        email: String,
        nik: String,
        password: String,
        confPassword: String,
    ): Boolean {
        return when {
            name.isEmpty() -> {
                _errorMessage.value = "Nama tidak boleh kosong"
                false
            }
            phone.isEmpty() -> {
                _errorMessage.value = "Nomor telepon tidak boleh kosong"
                false
            }
            email.isEmpty() -> {
                _errorMessage.value = "Email tidak boleh kosong"
                false
            }
            password.isEmpty() -> {
                _errorMessage.value = "Password tidak boleh kosong"
                false
            }
            nik.isEmpty() -> {
                _errorMessage.value = "NIK tidak boleh kosong"
                false
            }
            confPassword.isEmpty() -> {
                _errorMessage.value = "Konfirmasi password tidak boleh kosong"
                false
            }
            password != confPassword -> {
                _errorMessage.value = "Password tidak sama"
                false
            }
            else -> true
        }
    }

}