package com.example.product1.addtovar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class AddTovarViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel ?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddTovarViewModel::class.java)) {
            return AddTovarViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}