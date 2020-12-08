package com.jadeappstudio.pembukuantk.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jadeappstudio.pembukuantk.EditCustomerActivity
import com.jadeappstudio.pembukuantk.EditProductActivity
import com.jadeappstudio.pembukuantk.R
import kotlinx.android.synthetic.main.activity_detail_customer.*

class DetailCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_customer)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        val customerId = intent.getIntExtra("customerId", 0)
        val customerName = intent.getStringExtra("customerName")
        val customerPhone = intent.getStringExtra("customerPhone")
        val customerEmail = intent.getStringExtra("customerEmail")
        val customerAddress = intent.getStringExtra("customerAddress")

        tvCustomerName.text = customerName
        tvCustomerPhone.text = customerPhone
        tvCustomerEmail.text = customerEmail
        tvCustomerAddress.text = customerAddress

        btnEditCustomer.setOnClickListener {
            intent = Intent(this, EditCustomerActivity::class.java)
            intent.putExtra("customerId", customerId)
            intent.putExtra("customerName", customerName)
            intent.putExtra("customerPhone", customerPhone)
            intent.putExtra("customerEmail", customerEmail)
            intent.putExtra("customerAddress", customerAddress)
            startActivity(intent)
        }
    }
}