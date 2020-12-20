package com.example.purchase.repository

import androidx.lifecycle.LiveData
import com.example.purchase.data.PurchaseDao
import com.example.purchase.model.Purchase

class PurchaseRepository(private val purchaseDao: PurchaseDao) {

    val readAllData: LiveData<List<Purchase>> = purchaseDao.readAllData()

    fun addPurchase(purchase: Purchase){
        purchaseDao.addPurchase(purchase)
    }

    fun updatePurchase(purchase: Purchase){
        purchaseDao.updatePurchase(purchase)
    }

    fun deletePurchase(purchase: Purchase){
        purchaseDao.deletePurchase(purchase)
    }

    fun deleteAllPurchase(){
        purchaseDao.deleteAllPurchase()
    }

}