package com.example.product1.tovarslist

import androidx.lifecycle.ViewModel
import timber.log.Timber

class TovarListViewModel : ViewModel() {

    var tovar = arrayOf( "Понеділок", "Вівторок", "Середа", "Четвер", "Пятниця")

    init {
        Timber.i("TovarListViewModel");
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("TovarListViewModel destroyed");
    }
}