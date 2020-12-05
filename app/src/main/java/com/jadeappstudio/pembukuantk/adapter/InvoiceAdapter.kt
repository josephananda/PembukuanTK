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