/*
 * Created by Joseph Ananda Sugihdharma on 12/11/20 11:41 PM .
 * Copyright (c) 2020 . All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jadeappstudio.pembukuantk.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.ItemListInvoice
import com.jadeappstudio.pembukuantk.model.ProductItemListResponse
import com.jadeappstudio.pembukuantk.viewmodel.AddInvoiceViewModel
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