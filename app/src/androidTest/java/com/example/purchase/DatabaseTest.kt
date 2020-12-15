package com.example.purchase

import androidx.room.Room
import androidx.test.runner.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.purchase.data.PurchaseDao
import com.example.purchase.data.PurchaseDatabase
import com.example.purchase.model.Purchase
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var purchaseDao: PurchaseDao
    private lateinit var db: PurchaseDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, PurchaseDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        purchaseDao = db.purchaseDao()
    }
    //
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
    //
    @Test
    @Throws(Exception::class)
     fun insertPurchase() {
        val item = Purchase(0, "crips", "100", "25",  "Troi")
        purchaseDao.addPurchase(item)
        val user = purchaseDao.readAllData()
        assertNotNull(user)
    }
}