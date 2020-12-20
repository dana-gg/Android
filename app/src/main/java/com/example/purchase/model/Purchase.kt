package com.example.purchase.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "purchase_table")
data class Purchase(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nameProduct: String,
    val count: String,
    val price: String,
    val manufacturer: String
): Parcelable