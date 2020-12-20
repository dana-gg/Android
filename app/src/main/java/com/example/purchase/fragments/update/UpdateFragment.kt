package com.example.purchase.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.purchase.R
import com.example.purchase.data.PurchaseDatabase
import com.example.purchase.model.Purchase
import com.example.purchase.viewmodel.PurchaseViewModel
import com.example.purchase.viewmodel.PurchaseViewModelFactory
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mPurchaseViewModelFactory: PurchaseViewModelFactory
    private lateinit var mPurchaseViewModel: PurchaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = PurchaseDatabase.getDatabase(application).purchaseDao()

        mPurchaseViewModelFactory = PurchaseViewModelFactory(dataSource, application)
        mPurchaseViewModel = ViewModelProviders.of(this, mPurchaseViewModelFactory).get(PurchaseViewModel::class.java)

        view.updateNameProduct_et.setText(args.currentPurchase.nameProduct)
        view.updateCount_et.setText(args.currentPurchase.count)
        view.updatePrice_et.setText(args.currentPurchase.price)
        view.updateManufacturer_et.setText(args.currentPurchase.manufacturer)

        view.update_btn.setOnClickListener {
            updateItem()
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val nameProduct = updateNameProduct_et.text.toString()
        val count = updateCount_et.text.toString()
        val price = updatePrice_et.text.toString()
        val manufacturer = updateManufacturer_et.text.toString()

        if (inputCheck(nameProduct, count, price, manufacturer )) {
            // Create User Object
            val updatedPurchase = Purchase(args.currentPurchase.id, nameProduct, count, price, manufacturer)
            // Update Current User
            mPurchaseViewModel.updatePurchase(updatedPurchase)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(nameProduct: String, count: String, price: String, manufacturer: String): Boolean {
        return !(TextUtils.isEmpty(nameProduct) && TextUtils.isEmpty(count) && TextUtils.isEmpty(price)
                && TextUtils.isEmpty(manufacturer))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deletePurchase()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deletePurchase() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mPurchaseViewModel.deletePurchase(args.currentPurchase)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${args.currentPurchase.nameProduct}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentPurchase.nameProduct}?")
        builder.setMessage("Are you sure you want to delete ${args.currentPurchase.nameProduct}?")
        builder.create().show()
    }
}