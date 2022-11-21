package com.eros.gestariwastebank.main.home.pricelist.ui.metal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MetalViewModel {
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}