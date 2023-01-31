package com.eros.gestariwastebank.main.home.transaction.viewmodel

import android.util.Log
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
    val cartItem: LiveData<List<Cart>> = _cartItem

    private val _deleteFavorite = MutableLiveData<Unit>()
    val deleteFavorite: LiveData<Unit> = _deleteFavorite

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val _totalItem = MutableLiveData<Int>()
    val totalItem: LiveData<Int> = _totalItem

    private val _saldoDapat = MutableLiveData<Int>()
    val saldoDapat: LiveData<Int> = _saldoDapat

    fun getDataCart() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.getCart()
                }
            }.onSuccess { data ->
                withContext(Dispatchers.Main) {
                    _cartItem.value = data
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
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
                withContext(Dispatchers.Main) {
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
                withContext(Dispatchers.Main) {
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
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                }
            }
        }
    }

    fun deleteData(item: Cart) {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.deleteCart(item)
                }
            }.onSuccess {
                withContext(Dispatchers.Main) {
                    _deleteFavorite.value = Unit
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                }
            }
        }
    }

    fun getRowCount(): Int {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.getRowCount()
                }
            }.onSuccess { data ->
                withContext(Dispatchers.Main) {
                    _totalItem.value = data
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                }
            }
        }
        return _totalItem.value ?: 0
    }

    fun getProductById(id: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.getProductById(id)
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                }
            }
        }
    }

    fun dropDatabase() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.dropDatabase()
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                }
            }
        }
    }

    fun getTotalGet() : Int {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    repository.getTotalGet()
                }
            }.onSuccess { data ->
                withContext(Dispatchers.Main) {
                    _saldoDapat.value = data
                    Log.d("dataAmount", "getTotalGet: $data")
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = error.message
                }
            }
        }
        return _saldoDapat.value ?: 0
    }
}
