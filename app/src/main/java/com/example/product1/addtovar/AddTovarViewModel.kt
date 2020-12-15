package com.example.product1.addtovar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class AddTovarViewModel : ViewModel() {

    private val _name_product = MutableLiveData<String>()
    val name_product : LiveData<String>
        get() = _name_product

    private val _price = MutableLiveData<String>()
    val price : LiveData<String>
        get() = _price

    private val _count = MutableLiveData<String>()
    val count : LiveData<String>
        get() = _count

    private val _manufacturer  = MutableLiveData<String>()
    val manufacturer : LiveData<String>
        get() = _manufacturer

    init {
        Timber.i("AddTovarViewModel Created");
        _name_product.value = ""
        _price.value = ""
        _count.value = ""
        _manufacturer.value = ""
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("AddTovarViewModel destroyed");
    }
}