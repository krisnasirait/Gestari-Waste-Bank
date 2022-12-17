package com.eros.gestariwastebank.main.home.artikel.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eros.gestariwastebank.data.Util
import com.eros.gestariwastebank.data.model.news.News
import com.eros.gestariwastebank.domain.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(
    private val repository: Repository
)  : ViewModel(){

    private val _news: MutableLiveData<List<News?>?> = MutableLiveData()
    val news: LiveData<List<News?>?> = _news

    private val _errorMessage : MutableLiveData<String> = MutableLiveData()
    val errorMessage : LiveData<String> = _errorMessage

    private val _isLoading = MutableLiveData<String>()
    val isLoading: LiveData<String> = _isLoading

    fun getNews() {
        viewModelScope.launch {
            kotlin.runCatching {
                _isLoading.value = "loading"
                withContext(Dispatchers.IO){
                    repository.getNews()
                }
            }.onSuccess { data ->
                withContext(Dispatchers.Main){
                    _news.value = data.data
                    _isLoading.value = "done"
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main){
                    _errorMessage.value = error.message
                    Log.d("errorNews", "getNews: ${error.message}")
                    _isLoading.value = "error"
                }
            }
        }
    }
}