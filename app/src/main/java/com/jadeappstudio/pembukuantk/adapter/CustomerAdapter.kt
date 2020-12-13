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

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.CustomerItemListResponse
import com.jadeappstudio.pembukuantk.ui.DetailCustomerActivity

class CustomerAdapter(private val customerItem: List<CustomerItemListResponse>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    inner class CustomerViewHolder(items: View) : RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_customer, parent, false)
        return CustomerViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.itemView.apply {
            val tvCustomerName = findViewById<TextView>(R.id.tvCustomerName)
            val tvCustomerPhone = findViewById<TextView>(R.id.tvCustomerPhone)

            tvCustomerName.text = customerItem[position].name ?: ""
            tvCustomerPhone.text = customerItem[position].phone ?: ""

            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailCustomerActivity::class.java)
                intent.putExtra("customerId", customerItem[position].id)
                intent.putExtra("customerName", customerItem[position].name)
                intent.putExtra("customerPhone", customerItem[position].phone)
                intent.putExtra("customerEmail", customerItem[position].email)
                intent.putExtra("customerAddress", customerItem[position].address)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return customerItem.size
    }
}