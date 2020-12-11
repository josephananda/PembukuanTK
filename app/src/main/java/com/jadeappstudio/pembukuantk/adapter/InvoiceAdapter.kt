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
import com.jadeappstudio.pembukuantk.ui.DetailInvoiceActivity
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.model.InvoiceResp
import java.text.SimpleDateFormat
import java.util.*

class InvoiceAdapter(val invoiceResp: List<InvoiceResp>) :
    RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder>() {

    inner class InvoiceViewHolder(items: View) : RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoiceViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_detail_invoice, parent, false)
        return InvoiceViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: InvoiceViewHolder, position: Int) {
        holder.itemView.apply {
            val tvInvoiceNumber = findViewById<TextView>(R.id.tvInvoiceNumber)
            val tvTimeStamp = findViewById<TextView>(R.id.tvTimeStamp)
            val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

            tvInvoiceNumber.text = "Invoice#${invoiceResp[position].id}"
            var time = invoiceResp[position].updated_at ?: ""
            var convertedTime = convertLongToTime(time.toLong())
            tvTimeStamp.text = convertedTime
            tvTotalPrice.text = "Rp ${invoiceResp[position].total_invoice_price}"

            holder.itemView.setOnClickListener{
                val intent = Intent(context, DetailInvoiceActivity::class.java)
                intent.putExtra("invoiceId", invoiceResp[position].id)
                intent.putExtra("customerName", invoiceResp[position].customer_name)
                intent.putExtra("customerPhone", invoiceResp[position].customer_phone)
                intent.putExtra("customerEmail", invoiceResp[position].customer_email)
                intent.putExtra("customerAddress", invoiceResp[position].customer_address)
                intent.putExtra("timeStamp", convertedTime)
                intent.putExtra("totalPrice", invoiceResp[position].total_invoice_price)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return invoiceResp.size
    }

    private fun convertLongToTime(time: Long): String {
        val date = Date(time * 1000)
        val format = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        format.timeZone = TimeZone.getTimeZone("Asia/Jakarta")
        return format.format(date)
    }
}