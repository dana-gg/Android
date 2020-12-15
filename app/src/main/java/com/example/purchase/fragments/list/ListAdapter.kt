package com.example.purchase.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.purchase.R
import com.example.purchase.model.Purchase
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var PurchaseList = emptyList<Purchase>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
       return PurchaseList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = PurchaseList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.NameProduct_txt.text = currentItem.nameProduct
        holder.itemView.Count_txt.text = currentItem.count
        holder.itemView.Price_txt.text = currentItem.price
        holder.itemView.Manufacturer_txt.text = currentItem.manufacturer

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(purchase: List<Purchase>){
        this.PurchaseList = purchase
        notifyDataSetChanged()
    }
}