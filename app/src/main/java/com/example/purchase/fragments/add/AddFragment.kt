package com.example.purchase.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.purchase.R
import com.example.purchase.data.PurchaseDatabase
import com.example.purchase.model.Purchase
import com.example.purchase.viewmodel.PurchaseViewModel
import com.example.purchase.viewmodel.PurchaseViewModelFactory
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mPurchaseViewModelFactory: PurchaseViewModelFactory
    private lateinit var mPurchaseViewModel: PurchaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = PurchaseDatabase.getDatabase(application).purchaseDao()

        mPurchaseViewModelFactory = PurchaseViewModelFactory(dataSource, application)
        mPurchaseViewModel = ViewModelProviders.of(this, mPurchaseViewModelFactory).get(PurchaseViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val nameProduct = addNameProduct_et.text.toString()
        val count = addCount_et.text.toString()
        val price = addPrice_et.text.toString()
        val manufacturer = addManufacturer_et.text.toString()

        if(inputCheck(nameProduct, count, price, manufacturer  )){
            // Create User Object
            val user = Purchase(
                0,
                nameProduct,
                count,
                price,
                manufacturer
            )
            // Add Data to Database
            mPurchaseViewModel.addPurchase(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(nameProduct: String, count: String, price: String, manufacturer: String): Boolean{
        return !(TextUtils.isEmpty(nameProduct) && TextUtils.isEmpty(count) && TextUtils.isEmpty(price)
                && TextUtils.isEmpty(manufacturer))
    }

}