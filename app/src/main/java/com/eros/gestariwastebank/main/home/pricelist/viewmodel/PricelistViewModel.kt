package com.eros.gestariwastebank.main.home.pricelist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eros.gestariwastebank.data.model.catalog.Catalog
import com.eros.gestariwastebank.data.model.catalog.CatalogResponse
import com.eros.gestariwastebank.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PricelistViewModel(
    private val repository: Repository
)  : ViewModel(){

    private val _catalog: MutableLiveData<List<Catalog?>> = MutableLiveData()
    val catalog: LiveData<List<Catalog?>> = _catalog

    private val _errorMessage : MutableLiveData<String> = MutableLiveData()
    val errorMessage : LiveData<String> = _errorMessage

    fun getCatalog() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO){
                    repository.getCatalog().data
                }
            }.onSuccess { data ->
                withContext(Dispatchers.Main){
                    _catalog.value = data
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main){
                    _errorMessage.value = error.message
                }
            }
        }
    }
}