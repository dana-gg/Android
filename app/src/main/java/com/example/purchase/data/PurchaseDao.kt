package com.example.purchase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.purchase.model.Purchase

@Dao
interface PurchaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPurchase(purchase: Purchase)

    @Update
    fun updatePurchase(purchase: Purchase)

    @Delete
    fun deletePurchase(purchase: Purchase)

    @Query("DELETE FROM purchase_table")
    fun deleteAllPurchase()

    @Query("SELECT * FROM purchase_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Purchase>>

}