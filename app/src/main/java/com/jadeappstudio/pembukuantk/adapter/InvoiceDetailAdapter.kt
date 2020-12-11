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