package com.example.product1.tovardetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TovarDetailsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TovarDetailsViewModel::class.java)) {
            return TovarDetailsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}