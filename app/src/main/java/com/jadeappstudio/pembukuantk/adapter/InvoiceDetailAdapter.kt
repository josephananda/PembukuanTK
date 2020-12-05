package com.jadeappstudio.pembukuantk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.ItemInvoice

class InvoiceDetailAdapter(val itemInvoice: List<ItemInvoice>) :
    RecyclerView.Adapter<InvoiceDetailAdapter.InvoiceDetailViewHolder>() {

    inner class InvoiceDetailViewHolder(items: View) : RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoiceDetailViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_invoice, parent, false)
        return InvoiceDetailViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: InvoiceDetailViewHolder, position: Int) {
        holder.itemView.apply {
            val tvProductName = findViewById<TextView>(R.id.tvProductName)
            val tvProductQuantityAndPrice = findViewById<TextView>(R.id.tvProductQuantityAndPrice)
            val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

            tvProductName.text = "${itemInvoice[position].product_name}"
            tvProductQuantityAndPrice.text = "${itemInvoice[position].product_qty} x @${itemInvoice[position].product_price}"
            tvTotalPrice.text = "Rp ${itemInvoice[position].product_total_price}"
        }
    }

    override fun getItemCount(): Int {
        return itemInvoice.size
    }
}