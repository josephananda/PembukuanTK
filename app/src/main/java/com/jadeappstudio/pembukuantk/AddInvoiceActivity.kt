package com.jadeappstudio.pembukuantk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadeappstudio.pembukuantk.adapter.InvoiceItemAdapter
import com.jadeappstudio.pembukuantk.ui.BottomNavActivity
import kotlinx.android.synthetic.main.activity_add_invoice.*

class AddInvoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_invoice)

        val viewModel = ViewModelProvider(this).get(AddInvoiceViewModel::class.java)

        tvCustomerName.text = intent.getStringExtra("custName")?: ""
        tvCustomerPhone.text = intent.getStringExtra("custPhone")?: ""
        tvCustomerAddress.text = intent.getStringExtra("custAddress")?: ""

        btnBack.setOnClickListener {
            onBackPressed()
        }

        btnChooseCustomer.setOnClickListener {
            startActivity(Intent(this, ChooseCustomerActivity::class.java))
        }

        viewModel.getProduct(this).observe(this, {
            if (it.data != null) {
                val adapter = InvoiceItemAdapter(it.data, viewModel, this)
                rvItems.layoutManager = LinearLayoutManager(this)
                rvItems.adapter = adapter
            }
        })

        btnConfirm.setOnClickListener {
            btnConfirm.isClickable = false
            if(!viewModel.checkIfZero()) {
                viewModel.addInvoice(intent.getIntExtra("custId", 0), this).observe(this, {
                    startActivity(Intent(this, BottomNavActivity::class.java))
                })
            } else {
                viewModel.clearList()
                btnConfirm.isClickable = true
                Toast.makeText(this, "NO ITEM ADDED", Toast.LENGTH_LONG).show()
            }
        }
    }
}