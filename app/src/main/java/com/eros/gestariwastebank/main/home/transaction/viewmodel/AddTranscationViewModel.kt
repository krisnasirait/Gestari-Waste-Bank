package com.eros.gestariwastebank.main.home.transaction.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eros.gestariwastebank.data.model.cart.Cart
import com.eros.gestariwastebank.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddTranscationViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _cartItem = MutableLiveData<List<Cart>>()
    val cartItem : LiveData<List<Cart>> = _cartItem

    private val _deleteFavorite = MutableLiveData<Unit>()
    val deleteFavorite : LiveData<Unit> = _deleteFavorite

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> = _errorMessage

    fun getDataCart () {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO){
                    repository.getCart()
                }
            }.onSuccess { data ->
                withContext(Dispatchers.Main){
                    _cartItem.value = data
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main){
                    _errorMessage.value = error.message
                }
            }
        }
    }

    fun insertDataCart(id: Int, name: String, itemImage: String, amount: Int, price: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.addOrInsertCartById(id, name, itemImage, amount, price)
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main){
                    _errorMessage.value = error.message
                }
            }
        }
    }

    fun increaseAmount(id: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.incrementQuantity(id)
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main){
                    _errorMessage.value = error.message
                }
            }
        }
    }

    fun decreaseAmount(id: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.decrementQuantity(id)
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main){
                    _errorMessage.value = error.message
                }
            }
        }
    }
}
