package com.eros.gestariwastebank.main.auth.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eros.gestariwastebank.data.model.login.Login
import com.eros.gestariwastebank.data.remote.networking.request.LoginRequest
import com.eros.gestariwastebank.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val repository: Repository
) : ViewModel() {


    private val _login: MutableLiveData<Login?> = MutableLiveData()
    val login: LiveData<Login?> = _login

    private val _errorMessage : MutableLiveData<String> = MutableLiveData()
    val errorMessage : LiveData<String> = _errorMessage

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO){
                    repository.loginUser(loginRequest)
                }
            }.onSuccess { data ->
                withContext(Dispatchers.Main){
                    _login.value = data.result
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                    Log.d("errorStatus : ", _errorMessage.value.toString())
                }
            }
        }
    }
}