package com.example.product1.tovarslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TovarListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TovarListViewModel::class.java)) {
            return TovarListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}