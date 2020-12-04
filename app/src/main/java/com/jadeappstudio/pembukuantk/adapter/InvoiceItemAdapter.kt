package com.jadeappstudio.pembukuantk.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jadeappstudio.pembukuantk.AddInvoiceViewModel
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.ItemListInvoice
import com.jadeappstudio.pembukuantk.model.ProductItemListResponse
import kotlinx.android.synthetic.main.item_invoice.view.*

class InvoiceItemAdapter(
    private var productItem: List<ProductItemListResponse>,
    private val viewModel: AddInvoiceViewModel,
    var context: Context
) :
    RecyclerView.Adapter<InvoiceItemAdapter.InvoiceViewHolder>() {
    inner class InvoiceViewHolder(items: View) : RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoiceViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_invoice, parent, false)
        return InvoiceViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: InvoiceViewHolder, position: Int) {
        val currentItem = productItem[position]

        holder.itemView.apply {
            val tvProductName = findViewById<TextView>(R.id.tvProductName)
            val tvProductPrice = findViewById<TextView>(R.id.tvProductPrice)
            val tvAmount = findViewById<TextView>(R.id.tvAmount)
            tvProductName.text = productItem[position].name
            tvProductPrice.text = "Rp ${productItem[position].price}"
            tvAmount.text = currentItem.quantity.toString()
        }

        holder.itemView.btnPlus.setOnClickListener {
            currentItem.quantity = (currentItem.quantity?.plus(1))
            holder.itemView.tvAmount.text = currentItem.quantity.toString()
            val item = ItemListInvoice(currentItem.id, 1)
            viewModel.pushToList(item)
        }

        holder.itemView.btnMinus.setOnClickListener {
            if (currentItem.quantity!! > 0) {
                currentItem.quantity = (currentItem.quantity?.minus(1))
                holder.itemView.tvAmount.text = currentItem.quantity.toString()
                val item = ItemListInvoice(currentItem.id, -1)
                viewModel.pushToList(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return productItem.size
    }

}