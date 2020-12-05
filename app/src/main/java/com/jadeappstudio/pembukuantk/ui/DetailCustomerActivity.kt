package com.jadeappstudio.pembukuantk.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jadeappstudio.pembukuantk.R
import kotlinx.android.synthetic.main.activity_detail_customer.*

class DetailCustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_customer)

        btnBack.setOnClickListener {
            onBackPressed()
        }

        tvCustomerName.text = intent.getStringExtra("customerName")
        tvCustomerPhone.text = intent.getStringExtra("customerPhone")
        tvCustomerEmail.text = intent.getStringExtra("customerEmail")
        tvCustomerAddress.text = intent.getStringExtra("customerAddress")
    }
}