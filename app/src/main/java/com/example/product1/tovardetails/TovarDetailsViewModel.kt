package com.example.product1.tovardetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class TovarDetailsViewModel : ViewModel() {

    private val _name_product = MutableLiveData<String>()
    val name_product : LiveData<String>
        get() = _name_product

    private val _price  = MutableLiveData<String>()
    val price : LiveData<String>
        get() = _price

    private val _count = MutableLiveData<String>()
    val count : LiveData<String>
        get() = _count

    private val _manufacturer = MutableLiveData<String>()
    val manufacturer : LiveData<String>
        get() = _manufacturer

    init {
        Timber.i("TovarDetailsViewModel Created");
        _name_product.value = "Авокадо"
        _price.value = "Ціна 250"
        _count.value = "10 штук"
        _manufacturer.value = "Азія"
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("AddTovarViewModel destroyed");
    }
}