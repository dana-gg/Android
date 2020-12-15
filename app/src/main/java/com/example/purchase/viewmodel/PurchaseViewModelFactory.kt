package com.example.purchase.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.purchase.data.PurchaseDao

class PurchaseViewModelFactory(
    private  val dataSource: PurchaseDao,
    private  val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PurchaseViewModel::class.java)) {
            return PurchaseViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}