package com.example.purchase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.purchase.data.PurchaseDao
import com.example.purchase.repository.PurchaseRepository
import com.example.purchase.model.Purchase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PurchaseViewModel(val database: PurchaseDao, application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Purchase>>
    private val repository: PurchaseRepository

    init {
        repository = PurchaseRepository(database)
        readAllData = repository.readAllData
    }

    fun addPurchase(purchase: Purchase){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPurchase(purchase)
        }
    }

    fun updatePurchase(purchase: Purchase){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePurchase(purchase)
        }
    }

    fun deletePurchase(purchase: Purchase){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePurchase(purchase)
        }
    }

    fun deleteAllPurchase(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPurchase()
        }
    }

}