package com.jadeappstudio.pembukuantk.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadeappstudio.pembukuantk.viewmodel.DetailInvoiceViewModel
import com.jadeappstudio.pembukuantk.R
import com.jadeappstudio.pembukuantk.adapter.InvoiceDetailAdapter
import kotlinx.android.synthetic.main.activity_detail_invoice.*

class DetailInvoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_invoice)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        var invoiceId = intent.getIntExtra("invoiceId", 0)

        tvInvoiceId.text = invoiceId.toString()
        tvCustomerName.text = intent.getStringExtra("customerName")
        tvCustomerPhone.text = intent.getStringExtra("customerPhone")
        tvCustomerAddress.text = intent.getStringExtra("customerAddress")
        tvTimeStamp.text = intent.getStringExtra("timeStamp")
        tvAmount.text = "Rp ${intent.getStringExtra("totalPrice")}"

        var viewModel = ViewModelProvider(this).get(DetailInvoiceViewModel::class.java)

        viewModel.getInvoiceDetail(invoiceId, this).observe(this, {
            if (it.data != null) {
                rvInvoice.adapter = InvoiceDetailAdapter(it.data.products)
                rvInvoice.layoutManager = LinearLayoutManager(this)
            }
        })
    }
}