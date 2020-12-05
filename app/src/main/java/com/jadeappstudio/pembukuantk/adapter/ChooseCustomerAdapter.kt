package com.jadeappstudio.pembukuantk.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jadeappstudio.pembukuantk.ui.AddInvoiceActivity
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.CustomerItemListResponse

class ChooseCustomerAdapter(val customerItem: List<CustomerItemListResponse>): RecyclerView.Adapter<ChooseCustomerAdapter.CustomerViewHolder>(){
    inner class CustomerViewHolder(items: View): RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_customer, parent, false)
        return CustomerViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.itemView.apply{
            val tvCustomerName = findViewById<TextView>(R.id.tvCustomerName)
            val tvCustomerPhone = findViewById<TextView>(R.id.tvCustomerPhone)

            tvCustomerName.text = customerItem[position].name?: ""
            tvCustomerPhone.text = customerItem[position].phone?:""

            holder.itemView.setOnClickListener{
                val intent = Intent(context, AddInvoiceActivity::class.java)
                intent.putExtra("custId", customerItem[position].id)
                intent.putExtra("custName", customerItem[position].name)
                intent.putExtra("custPhone", customerItem[position].phone)
                intent.putExtra("custEmail", customerItem[position].email)
                intent.putExtra("custAddress", customerItem[position].address)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return customerItem.size
    }
}